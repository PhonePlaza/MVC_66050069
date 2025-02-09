package MVC_66050069.Model;

// Class Owl ใช้แทนข้อมูลของนกฮูกและกฎการตรวจสอบของนกฮูก
public class Owl extends Pet {
    private double flightDistance; // ระยะทางการบินของนกฮูก
    
    // Constructor สำหรับสร้างอ็อบเจ็กต์นกฮูก
    public Owl(String foodId, String lastHealthCheck, int vaccineCount, double flightDistance) {
        super(foodId, "Owl", lastHealthCheck, vaccineCount);
        this.flightDistance = flightDistance;
    }

    // Getter สำหรับระยะทางการบิน
    public double getFlightDistance() {
        return flightDistance;
    }

    // ตรวจสอบว่าสัตว์ผ่านเงื่อนไขการนำเข้าได้หรือไม่
    @Override
    public boolean validate() {
        return flightDistance >= 100; // ถ้าระยะทางบินน้อยกว่า 100 กม. จะไม่ผ่านการตรวจสอบ
    }
}

