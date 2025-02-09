package MVC_66050069.Controller;
import MVC_66050069.Model.*;

// PetController ควบคุมการทำงานระหว่าง View และ Model
public class PetController {
    private boolean lastAddedPetValid = false; // เก็บค่าผลการตรวจสอบสัตว์ตัวล่าสุด

    public boolean isLastAddedPetValid() {
        return lastAddedPetValid;
    }

    private PetDatabase database;

    // Constructor รับ Object ฐานข้อมูลสัตว์เลี้ยง
    public PetController(PetDatabase database) {
        this.database = database;
    }

    // เพิ่มนกฟินิกซ์
    public void addPhoenix(String lastHealthCheck, int vaccineCount, boolean fireproofCertificate) {
        Phoenix phoenix = new Phoenix(generateFoodId(), lastHealthCheck, vaccineCount, fireproofCertificate);
        database.addPet(phoenix);
        lastAddedPetValid = phoenix.validate(); // ตรวจสอบว่าสัตว์ตัวนี้ผ่านการตรวจสอบหรือไม่
    }

    // เพิ่มมังกร
    public void addDragon(String lastHealthCheck, int vaccineCount, double smokePollutionLevel) {
        Dragon dragon = new Dragon(generateFoodId(), lastHealthCheck, vaccineCount, smokePollutionLevel);
        database.addPet(dragon);
        lastAddedPetValid = dragon.validate(); // ตรวจสอบว่าสัตว์ตัวนี้ผ่านการตรวจสอบหรือไม่
    }

    // เพิ่มนกฮูก
    public void addOwl(String lastHealthCheck, int vaccineCount, double flightDistance) {
        Owl owl = new Owl(generateFoodId(), lastHealthCheck, vaccineCount, flightDistance);
        database.addPet(owl);
        lastAddedPetValid = owl.validate(); // ตรวจสอบว่าสัตว์ตัวนี้ผ่านการตรวจสอบหรือไม่
    }

    // สร้างรหัสอาหารแบบสุ่ม 8 หลัก
    private String generateFoodId() {
        return String.valueOf((long) (Math.random() * 90000000 + 10000000));
    }

    // สร้างรายงานข้อมูลสัตว์ทั้งหมด
    public String generateReport() {
        return database.generateReport();
    }
}