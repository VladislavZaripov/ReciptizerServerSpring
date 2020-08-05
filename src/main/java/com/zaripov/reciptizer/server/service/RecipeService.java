package com.zaripov.reciptizer.server.service;

import com.zaripov.reciptizer.server.entity.Recipe;

public interface RecipeService {

    void saveRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);
}