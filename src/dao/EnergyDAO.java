package dao;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnergyDAO {

    public void saveEnergy(double produced, double consumed, double storedEnergy) {

        String sql =
                "INSERT INTO energy_data (produced, consumed, stored_energy) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, produced);
            ps.setDouble(2, consumed);
            ps.setDouble(3, storedEnergy);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
