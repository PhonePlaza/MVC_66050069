package MVC_66050069.Model;

import java.io.*;
import java.util.*;

public class PetDatabase {
    private static final String FILE_PATH = "MVC_66050069/PetsData.csv";
    private List<Pet> pets = new ArrayList<>();

    // เพิ่มสัตว์เลี้ยงเข้า CSV
    public void addPet(Pet pet) {
        pets.add(pet);
        saveToFile(pet);

    }

    private void saveToFile(Pet pet) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            if (pet instanceof Phoenix) {
                Phoenix p = (Phoenix) pet;
                writer.write(p.getFoodId() + ",Phoenix," + p.getLastHealthCheck() + "," + p.getVaccineCount() + ","
                        + p.isFireproofCertificate());
            } else if (pet instanceof Dragon) {
                Dragon d = (Dragon) pet;
                writer.write(d.getFoodId() + ",Dragon," + d.getLastHealthCheck() + "," + d.getVaccineCount() + ","
                        + d.getSmokePollutionLevel());
            } else if (pet instanceof Owl) {
                Owl o = (Owl) pet;
                writer.write(o.getFoodId() + ",Owl," + o.getLastHealthCheck() + "," + o.getVaccineCount() + ","
                        + o.getFlightDistance());
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // อ่านข้อมูลจาก CSV
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return pets;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 5)
                    continue;

                String foodId = data[0];
                String type = data[1];
                String lastHealthCheck = data[2];
                int vaccineCount = Integer.parseInt(data[3]);

                Pet pet = null;
                if ("Phoenix".equals(type)) {
                    boolean fireproof = Boolean.parseBoolean(data[4]);
                    pet = new Phoenix(foodId, lastHealthCheck, vaccineCount, fireproof);
                } else if ("Dragon".equals(type)) {
                    double smokeLevel = Double.parseDouble(data[4]);
                    pet = new Dragon(foodId, lastHealthCheck, vaccineCount, smokeLevel);
                } else if ("Owl".equals(type)) {
                    double flightDistance = Double.parseDouble(data[4]);
                    pet = new Owl(foodId, lastHealthCheck, vaccineCount, flightDistance);
                }

                if (pet != null) {
                    pets.add(pet);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // สร้างรายงานสัตว์เลี้ยง
    public String generateReport() {
        List<Pet> pets = getAllPets();
        int phoenixCount = 0, dragonCount = 0, owlCount = 0;
        int accepted = 0, rejected = 0;

        for (Pet pet : pets) {
            if (pet instanceof Phoenix)
                phoenixCount++;
            else if (pet instanceof Dragon)
                dragonCount++;
            else if (pet instanceof Owl)
                owlCount++;

            if (pet.validate())
                accepted++;
            else
                rejected++;
        }

        return String.format(
                "Magic Pet Import Report\n" +
                        "----------------------------\n" +
                        "Phoenix: %d\n" +
                        "Dragon: %d\n" +
                        "Owl: %d\n" +
                        "----------------------------\n" +
                        "Accepted: %d\n" +
                        "Rejected: %d",
                phoenixCount, dragonCount, owlCount, accepted, rejected);
    }
}