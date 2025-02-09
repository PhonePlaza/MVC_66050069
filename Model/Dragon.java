package MVC_66050069.Model;

// Class Dragon ใช้แทนข้อมูลของมังกรและกฎการตรวจสอบของมังกร
public class Dragon extends Pet {
    private double smokePollutionLevel; // ระดับมลพิษควันของมังกร
    
    // Constructor สำหรับสร้าง Object มังกร
    public Dragon(String foodId, String lastHealthCheck, int vaccineCount, double smokePollutionLevel) {
        super(foodId, "Dragon", lastHealthCheck, vaccineCount);
        this.smokePollutionLevel = smokePollutionLevel;
    }

    // Getter สำหรับระดับมลพิษควัน
    public double getSmokePollutionLevel() {
        return smokePollutionLevel;
    }

    // ตรวจสอบว่าสัตว์ผ่านเงื่อนไขการนำเข้าได้หรือไม่
    @Override
    public boolean validate() {
        return smokePollutionLevel <= 70; // ถ้าค่ามลพิษเกิน 70% จะไม่ผ่านการตรวจสอบ
    }
}


