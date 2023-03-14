package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Training;

public class TrainingDao implements Dao<Training> {

	@Override
	public boolean create(Training obj) {
		String str = "INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory) VALUES (?,?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setString(1, obj.getTrainingName());
			ps.setString(2, obj.getDescription());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getCategory());
			ps.setInt(5, obj.getDuration());
			ps.setBoolean(6, obj.isDistential());
			ps.setInt(7, obj.getQuantity());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'une formation " + e.getMessage());
		}
		return false;
	}

	@Override
	public Training read(int id) {
		try (Statement statement = connection.createStatement()) {
			String str = "SELECT * FROM T_Trainings where IdTraining=" + id + ";";
			ResultSet rs = statement.executeQuery(str);
			if (rs.next())
				return new Training(id, rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6),
						rs.getBoolean(7), rs.getInt(8));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture d'une formation " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Training obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Training obj) {
		try (Statement statement = connection.createStatement()) {
			String str = "DELETE FROM T_Trainings where IdTraining=" + obj.getIdTraining() + ";";
			statement.executeUpdate(str);
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la suppression d'une formation " + e.getMessage());
		}
		return false;
	}

	@Override
	public ArrayList<Training> readAll() {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings";
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					int rsCategory = resultSet.getInt(5);
					int rsDuration = resultSet.getInt(6);
					boolean rsDistential = resultSet.getBoolean(7);
					int rsQuantity = resultSet.getInt(8);
					trainings.add((new Training(rsId, rsDescription, rsBrand, rsPrice, rsCategory, rsDuration,
							rsDistential, rsQuantity)));
				}
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations " + e.getMessage());
		} catch (Exception e) {
			logger.severe("pb : " + e.getMessage());
		}
		return trainings;
	}

	public ArrayList<Training> readAllByCat(int id) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings where idCategory=" + id;
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					int rsCategory = resultSet.getInt(5);
					int rsDuration = resultSet.getInt(6);
					boolean rsDistential = resultSet.getBoolean(7);
					int rsQuantity = resultSet.getInt(8);
					trainings.add((new Training(rsId, rsDescription, rsBrand, rsPrice, rsCategory, rsDuration,
							rsDistential, rsQuantity)));
				}
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations par catégories " + e.getMessage());
		}
		return trainings;
	}
}
