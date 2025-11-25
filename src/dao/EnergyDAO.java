package dao;

import model.EnergyRecord;
import service.EnergyService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EnergyDAO implements EnergyService {

    @Override
    public void addRecord(EnergyRecord record) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO energy VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, record.getProduction());
            ps.setDouble(2, record.getConsumption());
            ps.setDouble(3, record.getStorage());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Collection Example
    public List<EnergyRecord> getAllRecords() {
        List<EnergyRecord> list = new ArrayList<>();
        return list;
    }
}
