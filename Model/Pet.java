package MVC_66050069.Model;

// คลาสหลักของสัตว์เลี้ยง 
public abstract class Pet {
    protected String foodId; // รหัสอาหาร (เลข 8 หลัก ตัวแรกไม่ใช่ 0)
    protected String type; // ประเภทของสัตว์เลี้ยง
    protected String lastHealthCheck; // วันที่ตรวจสุขภาพล่าสุด
    protected int vaccineCount; // จำนวนวัคซีนที่ได้รับแล้ว

    public Pet(String foodId, String type, String lastHealthCheck, int vaccineCount) {
        this.foodId = foodId;
        this.type = type;
        this.lastHealthCheck = lastHealthCheck;
        this.vaccineCount = vaccineCount;
    }

    public abstract boolean validate(); // ตรวจสอบเงื่อนไขของสัตว์แต่ละประเภท

    public String getFoodId() { return foodId; }
    public String getType() { return type; }
    public String getLastHealthCheck() { return lastHealthCheck; }
    public int getVaccineCount() { return vaccineCount; }
}