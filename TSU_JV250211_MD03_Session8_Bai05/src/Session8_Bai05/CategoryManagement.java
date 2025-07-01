package Session8_Bai05;

public class CategoryManagement implements ICRUD{
    private Category[] categories = new Category[100];
    private int count = 0;

    @Override
    public Category[] findAll() {
        Category[] allCategories = new Category[count];
        for (int i = 0; i < count; i++) {
            allCategories[i] = categories[i];
        }
        return allCategories;
    }
    @Override
    public void addCategory(Category category) {
        if (count < categories.length) {
            boolean isExist = false;
            for (int i = 0; i < count; i++) {
                if (categories[i].getId() == category.getId()) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Lỗi: ID danh mục đã tồn tại. Vui lòng nhập ID khác.");
            } else  {
                categories[count] = category;
                count++;
                System.out.println("Danh mục đã được thêm.");
            }
        } else {
            System.err.println("Lỗi: Danh sách danh mục đã đầy.");
        }
    }
    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < count; i++) {
            if (categories[i].getId() == category.getId()) {
                categories[i] = category;
                System.out.println("Danh mục đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục với ID: " + category.getId());
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if (categories[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    categories[j] = categories[j + 1];
                }
                categories[count - 1] = null;
                count--;
                System.out.println("Danh mục đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục với ID: " + id);

    }
}
