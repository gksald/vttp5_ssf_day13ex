package sg.edu.nus.iss.vttp5_ssf_day13ex.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5_ssf_day13ex.model.Product;

@Service
public class ProductService {

    private static final String filePath = "src/main/resources/products.txt";
    List<Product> products = new ArrayList<>();

    public List<Product> loadProducts() {
        if (products.isEmpty()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(filePath));
                lines.remove(0); // Remove header line
                for (String line : lines) {
                    String[] parts = line.split(",\\s*");
                    Product product = new Product();
                    product.setItemId(Integer.parseInt(parts[0]));
                    product.setItemName(parts[1]);
                    product.setItemSold(Integer.parseInt(parts[2]));
                    product.setItemQuantity(Integer.parseInt(parts[3]));
                    product.setImage(parts[4]);
                    products.add(product);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return products;
    }
    

    public void buyProduct(int itemId) {
        for (Product product : products) {  // Find the product with the given itemId
            if (product.getItemId() == itemId && product.getItemQuantity() > 0) {
                product.setItemSold(product.getItemSold() + 1);
                product.setItemQuantity(product.getItemQuantity() - 1);
                
                saveProducts();
    
                break;
            }
        }
    }



    // try again...
    // public boolean buyProduct(int itemId) {
    //     for (Product product : products) {
    //         if (product.getItemId() == itemId) {
    //             if (product.getItemQuantity() > 0) {
    //                 product.setItemSold(product.getItemSold() + 1);
    //                 product.setItemQuantity(product.getItemQuantity() - 1);
    //                 saveProducts();  // Save the updated product list
    //                 return true;  // Indicate success
    //             }
    //             // Return false if out of stock
    //             return false;
    //         }
    //     }
    //     return false;  // Return false if itemId is not found
    // }    
    

    private void saveProducts() {
        try {
            List<String> lines = new ArrayList<>();
            lines.add("id, item, sold, quantity, picture");
            for (Product product : products) {
                lines.add(String.format("%d, %s, %d, %d, %s",
                    product.getItemId(),
                    product.getItemName(),
                    product.getItemSold(),
                    product.getItemQuantity(),
                    product.getImage()));
            }
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

 // to explicitly just read the file itself and load on webpage but not what we tryna do.
    // public List<String> readFile(String fileName) throws Exception {
    //     Path filePath = Paths.get("src/main/resources/" + fileName);
    //     return Files.readAllLines(filePath);