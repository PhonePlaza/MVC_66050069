package MVC_66050069;
import MVC_66050069.Model.PetDatabase;
import MVC_66050069.Controller.PetController;
import MVC_66050069.View.PetManagementView;

// คลาสหลักของโปรแกรม
public class Main {
    public static void main(String[] args) {
        // สร้าง Object ของฐานข้อมูลจำลอง
        PetDatabase database = new PetDatabase();

        // สร้าง Object ของ Controller และเชื่อมกับฐานข้อมูล
        PetController controller = new PetController(database);

        // สร้าง Object ของ View และเชื่อมกับ Controller
        PetManagementView view = new PetManagementView(controller);
        
        // แสดงหน้าต่าง View
        view.setVisible(true);
    }
}