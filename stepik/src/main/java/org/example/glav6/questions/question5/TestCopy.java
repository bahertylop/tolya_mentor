package org.example.glav6.questions.question5;

public class TestCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        for (CopyMethod copyMethod : CopyMethod.values()) {
            System.out.println("\nГлубокое копирование, используя " + copyMethod.description);
            testCopyObjectMethod(copyMethod);
        }
    }

    public static void testCopyObjectMethod(CopyMethod copyMethod) throws CloneNotSupportedException {
        Product product = createTestProduct();

        Product productCopy = switch (copyMethod) {
            case SERIALIZTION -> product.copyBySerialize();
            case CLONE -> product.clone();
            case CONSTRUCTOR -> new Product(product);
        };

        changeProduct(product);
        printCopyAfterChangeOriginal(productCopy);
    }

    private static Product createTestProduct() {
        Category category = new Category(1L, "shoes");
        Product product = new Product(1L, "adidas gazelle", "кеды адидас", category);
        printProductDetails("Изначальный продукт до изменения:", product);
        return product;
    }

    private static void changeProduct(Product product) {
        product.setCategory(new Category(2L, "category"));
        product.setDescription("кроссовки adidas");
//        product.getCategory().setName("category");
        printProductDetails("Изначальный продукт после изменения:", product);
    }

    private static void printCopyAfterChangeOriginal(Product productCopy) {
        printProductDetails("Копия продукта не изменилась после изменения изначального:", productCopy);
    }

    private static void printProductDetails(String message, Product product) {
        System.out.println(message);
        System.out.println(product);
    }

    private enum CopyMethod {
        CLONE("метод clone()"),
        SERIALIZTION("сериализацию"),
        CONSTRUCTOR("конструктор копирования");

        final String description;

        CopyMethod(String description) {
            this.description = description;
        }
    }
}

