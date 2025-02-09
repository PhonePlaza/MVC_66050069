Magic Pet Import System
Overview

Magic Pet Import System เป็นโปรแกรมจัดการนำเข้าสัตว์เลี้ยงเวทมนตร์ โดยใช้สถาปัตยกรรม MVC (Model-View-Controller) ในการพัฒนา โปรแกรมนี้ช่วยให้สามารถบันทึกและจัดการสัตว์เวทมนตร์ได้ 3 ประเภท ได้แก่ Phoenix (ฟีนิกซ์), Dragon (มังกร), และ Owl (นกฮูก)

Features

เพิ่มข้อมูลสัตว์แต่ละประเภท

ตรวจสอบและบันทึกข้อมูลสุขภาพ

แสดงรายงานสรุปข้อมูลสัตว์

ใช้งาน GUI ผ่าน JFrame และ JTabbedPane

Installation & Setup

1. Clone Repository

git clone <repository-url>
cd MagicPetImportSystem

2. Compile and Run

ใช้คำสั่งต่อไปนี้เพื่อคอมไพล์และรันโปรแกรม:

javac -d bin -sourcepath src src/MVC_66050069/Main.java
java -cp bin MVC_66050069.Main

Usage

เปิดโปรแกรม จะพบแท็บ 4 แท็บ: Report, Phoenix, Dragon, Owl

ไปที่แท็บสัตว์ที่ต้องการเพิ่มข้อมูล

กรอกข้อมูลสุขภาพ จำนวนวัคซีน และคุณสมบัติเฉพาะของสัตว์แต่ละประเภท

กดปุ่ม Add เพื่อบันทึกข้อมูล

ไปที่แท็บ Report แล้วกด Refresh Report เพื่อตรวจสอบข้อมูลที่บันทึก

File Structure
MagicPetImportSystem/
│── src/
│   ├── MVC_66050069/
│   │   ├── Model/
│   │   │   ├── Pet.java
│   │   │   ├── Phoenix.java
│   │   │   ├── Dragon.java
│   │   │   ├── Owl.java
│   │   │   ├── PetDatabase.java
│   │   ├── View/
│   │   │   ├── PetManagementView.java
│   │   ├── Controller/
│   │   │   ├── PetController.java
│   │   ├── Main.java
│── bin/ (compiled files)
│── README.md