package ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.dao.DatabaseAccess;
import ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.model.Product;


@Controller
public class contoller {
    @Autowired
    private DatabaseAccess pda;
    public ArrayList<Product> prods = new ArrayList<>();
    //default routing
    @GetMapping("/login")
    public String login_page() {
        return "/login";
    }
    @GetMapping("/index")
    public String index_page() {
        return "/index";
    }
    
    //ADMIN STUFF, WE CANT MAKE MORE THAN ONE CONTROLLER...
    @GetMapping("/admin/adding_templates/insert_product")
    public String insert_prod(Model model) {
        model.addAttribute("product", new Product());
        return "/admin/adding_templates/insert_product_input";
    }

    @GetMapping("/admin/insert_outcome")
    public String insert_outcome(@ModelAttribute Product product, Model model) {

        String message;
        long number_of_rows = pda.addProducts(product);
        if (number_of_rows > 0) {
            message = "AWESOME SAUCE!";
        } else {
            message = "OH MY, OH MY, OH MY";
        }
        model.addAttribute("message", message);
        return "/admin/adding_templates/insert_outcome";
    }

    //listing routing
    @GetMapping("/admin/list_products")
    public String list_all(Model model) {
        prods = (ArrayList) pda.selectProducts(0, "");
        model.addAttribute("products", prods); // showing all objects in database that are deletable
        return "/admin/list_all_products";
    }

    // MAPPING FOR SELECTED OBJECT
    @GetMapping("/admin/delete_product_info/{id}")
    @ResponseBody
    public String delete_confirm(Model model, @PathVariable("id") int id) {
        String message = "Are you sure you want to delete product with ID: " + id; // requesting confirmation from user
        String button = "<br/><a href='/admin/delete_product_confirmation/" + id + "'><button>Confirm</button></a>";
        String logout_template ="<br><div th:replace='/fragments/general.html :: logout> </div>";
        String footer_templater = "<br><div th:replace='/fragments/general.html :: footer'></div>";
        model.addAttribute("id", id);
        return message + button + logout_template + footer_templater;
    }

    // MAPPING FOR WHEN CONFIRM BUTTON IS PRESSED
    @GetMapping("/admin/delete_product_confirmation/{id}")
    public String delete_outcome(@PathVariable("id") int id, Model model) {
        long outcome = pda.deleteProduct(id);
        String message;
        if (outcome > 0) {
            message = "AWESOME SAUCE!";
        } else {
            message = "YOU'RE A DISAPPOINTMENT!";
        }
        model.addAttribute("message", message);
        return "/admin/deleting_templates/delete_outcome";
    }
        // EDITING PAGES
    /*
     * I used our handy array list here since we know the instance the user clicked
     * on to edit is apart of the list we used to diplay on the page
     * therefore avoiding having to make 3 requests to the Database to update one
     * instance, we only need to make two requests.
     * One of those requests in fact serves the purpose of providing access to both
     * deleting and editing rows.
     */
    @GetMapping("/admin/update_product_info/{id}")
    public String update_info_form(Model model, @PathVariable("id") int id) {
        Product prod = prods.get(id-1);
        model.addAttribute("prod", prod);// added for form binding
        return "/admin/editing_templates/update_product_info";
    }

    @GetMapping("/admin/update_outcome/{id}")
    public String update_outcome(Model model, @ModelAttribute Product prod, @PathVariable("id") int id) {
        long result = pda.update_row(id, prod);// given new information provided we use the id to send a request to
                                               // database to update instance
        String message;
        if (result > 0) {
            message = "AWESOME SAUCE. Successfully updated product with ID: " + id;
        } else {
            message = "WAH WAH";
        }
        model.addAttribute("message", message);
        return "/admin/editing_templates/update_outcome";
    }

    //declaring a fallback route for if user did not input any filters
    @GetMapping("/admin/apply_filters")
    public String display_then_filter(Model model, @RequestParam("filter") String filter ) {
        ArrayList<Product> prods = new ArrayList<>();
        int inp=0;
        try{
            inp = Integer.parseInt(filter);
            filter = "";
            prods = (ArrayList)pda.selectProducts(inp, filter);
            model.addAttribute("products", prods);
        }catch(Exception e){
            prods = (ArrayList)pda.selectProducts(inp, filter);
            model.addAttribute("products", prods);
        }
        return "/admin/list_all_products";
    }
    @GetMapping("/sales/apply_filters")
    public String display_then_filter_sales(Model model, @RequestParam("filter") String filter ) {
        ArrayList<Product> prods = new ArrayList<>();
        int inp=0;
        try{
            inp = Integer.parseInt(filter);
            filter = "";
            prods = (ArrayList)pda.selectProducts(inp, filter);
            model.addAttribute("products", prods);
        }catch(Exception e){
            prods = (ArrayList)pda.selectProducts(inp, filter);
            model.addAttribute("products", prods);
        }
        return "/sales/list_all_products";
    }
    
    //SALES ROUTING

    @GetMapping("/sales/list_products")
    public String list_all_sales(Model model) {
        prods = (ArrayList) pda.selectProducts(0, "");
        model.addAttribute("products", prods); // showing all objects in database that are deletable
        return "/sales/list_all_products";
    }

}
