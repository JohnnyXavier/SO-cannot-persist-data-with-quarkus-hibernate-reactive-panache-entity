package com.qrks;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/category")
public class CategoryResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<List<Category>> listAllCategories() {
    Category category = new Category();
    category.setName("name");

    return Category.add(category)
        .replaceWith(Category.findAll().list());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Uni<List<Category>> CreateCategory(final Category category) {
    return Category.add(category)
        .replaceWith(Category.findAll().list());
  }
}
