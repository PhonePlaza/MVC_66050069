package MVC_66050069.Model;

// คลาส Phoenix ใช้แทนข้อมูลของนกฟีนิกซ์และกฎการตรวจสอบของมัน
public class Phoenix extends Pet {
    private boolean fireproofCertificate; // ใบรับรองความสามารถทนไฟของนกฟีนิกซ์
    
    // Constructor สำหรับสร้างอ็อบเจ็กต์นกฟีนิกซ์
    public Phoenix(String foodId, String lastHealthCheck, int vaccineCount, boolean fireproofCertificate) {
        super(foodId, "Phoenix", lastHealthCheck, vaccineCount);
        this.fireproofCertificate = fireproofCertificate;
    }

    // ตรวจสอบว่าสัตว์ผ่านเงื่อนไขการนำเข้าได้หรือไม่
    @Override
    public boolean validate() {
        return fireproofCertificate; // นกฟีนิกซ์ต้องมีใบรับรองความสามารถทนไฟ (true) เท่านั้นจึงจะผ่านการตรวจสอบ
    }

    // Getter สำหรับตรวจสอบว่า Phoenix มีใบรับรองความสามารถทนไฟหรือไม่
    public boolean isFireproofCertificate() {
        return fireproofCertificate;
    }
}
