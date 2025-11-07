/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.categoryDTO;
import DTO.productDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.DbUtils;

/**
 *
 * @author Admin
 */
public class categoryDAO {
    

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<categoryDTO> getAllCategories() {
        List<categoryDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM tblCategory";
        try ( Connection con = DbUtils.getConnection();  PreparedStatement pst = con.prepareStatement(sql);  ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                categoryDTO c = new categoryDTO(
                        rs.getString("categoryId"),
                        rs.getString("categoryName"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<productDTO> getProductByCategoryId(String id) {
        List<productDTO> list = new ArrayList<>();
        String qr = "select * from tblProduct where categoryId=?";
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                productDTO p = new productDTO(
                        rs.getString("productId"),
                        rs.getString("productName"),
                        rs.getFloat("price"),
                        rs.getString("size"),
                        rs.getString("imageBase64"),
                        rs.getString("color"),
                        rs.getInt("quantity"),
                        rs.getString("description"),
                        rs.getString("categoryID")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static void main(String[] args) {
        categoryDAO cdao = new categoryDAO();
        List<productDTO> List = cdao.getProductByCategoryId("C01");
        for(productDTO p : List){
            System.out.println(p);
        }
    }

}
