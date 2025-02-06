package org.example.glav6.questions.question5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Product implements Cloneable, Serializable {

    private Long id;
    private String name;
    private String description;
    private Category category;

    public Product(Long id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.description = product.description;
        this.category = new Category(
                product.category.getId(),
                product.category.getName()
        );
    }

    @Override
    public Product clone() throws CloneNotSupportedException {

        Product clonedProduct = (Product) super.clone();

        clonedProduct.category = (Category) category.clone();

        return clonedProduct;
    }

    public Product copyBySerialize() {
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
        ) {
            oos.writeObject(this);
            oos.flush();

            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));) {
                return (Product) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
