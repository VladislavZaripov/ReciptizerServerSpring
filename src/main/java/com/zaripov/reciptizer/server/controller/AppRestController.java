package com.zaripov.reciptizer.server.controller;

import com.zaripov.reciptizer.server.entity.Recipe;
import com.zaripov.reciptizer.server.entity.RecipeFilter;
import com.zaripov.reciptizer.server.service.RecipeFilterService;
import com.zaripov.reciptizer.server.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("ReciptizerServer")
public class AppRestController {

    private final RecipeService recipeService;
    private final RecipeFilterService recipeFilterService;

    public AppRestController(RecipeService recipeService, RecipeFilterService recipeFilterService) {
        this.recipeService = recipeService;
        this.recipeFilterService = recipeFilterService;
    }

    @GetMapping("getRecipe/{id}")
    @ResponseBody
    public Recipe getRecipe(@PathVariable String id){
        return recipeService.getRecipe(Integer.parseInt(id));
    }

    @GetMapping("getFilter")
    @ResponseBody
    public RecipeFilter getFilter(){
        return recipeFilterService.getRecipeFilter();
    }

    @GetMapping("getImage/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable("imageName") String imageName){
        File file = new File("C://Users/zarip/Desktop/ImageSpring/" + imageName);
        byte[] imageInByte;
        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            return null;
        }
        return imageInByte;
    }

    @PostMapping ("postRecipe")
    public ResponseEntity postRecipe(@RequestBody Recipe recipe){
        recipeService.saveRecipe(recipe);
        return ResponseEntity.ok().body("Recipe saved");
    }

    @PostMapping("postImage/{imageName}")
    public ResponseEntity postImage(@PathVariable("imageName") String imageName, HttpServletRequest request) throws IOException {
        File file = new File("C://Users/zarip/Desktop/ImageSpring/" + imageName);
        InputStream inputStream = request.getInputStream();
        try {
            BufferedImage image = ImageIO.read(inputStream);
            OutputStream outputStream = new FileOutputStream(file);
            ImageIO.write(image,"png",outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            ResponseEntity.badRequest().body("Image not saved");
        }
        return ResponseEntity.ok().body("Image saved");
    }
}