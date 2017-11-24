package infrastructure;

import businessdomain.Customer;
import businessdomain.LoyaltyCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getLong("id"));
        customer.setName(rs.getString("name"));

        LoyaltyCard loyaltyCard = new LoyaltyCard();
        loyaltyCard.setId(rs.getLong("LoyalCard_ID"));
        loyaltyCard.setSum(rs.getDouble("sum"));
        customer.setLoyaltyCard(loyaltyCard);
        return customer;
    }
}
