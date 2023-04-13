package com.hpi.tpc.data.entities;

import java.sql.*;
import org.springframework.jdbc.core.*;

public class ValidateOptionTransactionMapper implements
    RowMapper<ValidateOptionTransactionModel> {
    @Override
    public ValidateOptionTransactionModel mapRow(ResultSet rs, int rowNum)
        throws SQLException {
        ValidateOptionTransactionModel votm;

        votm = ValidateOptionTransactionModel.builder()
            .joomlaId(rs.getInt("JoomlaId"))
            .acctId(rs.getInt("AcctId"))
            .equityId(rs.getString("EquityId"))
            .ticker(rs.getString("Ticker"))
            .secName(rs.getString("SecName"))
            .lastPrice(rs.getDouble("LastPrice"))
            .dtAsOf(rs.getString("DtAsOf"))
            .units(rs.getDouble("Units"))
            .tradePrice(rs.getDouble("TradePrice"))
            .markUpDn(rs.getDouble("MarkUpDn"))
            .commission(rs.getDouble("Commission"))
            .taxes(rs.getDouble("Taxes"))
            .fees(rs.getDouble("Fees"))
            .total(rs.getDouble("Total"))
            .brokerId(rs.getInt("BrokerId"))
            .dtTrade(rs.getString("DtTrade"))
            .fiTId(rs.getString("FiTId"))
            .transactionType(rs.getString("OptTransactionType"))
            .shPerCtrct(rs.getInt("ShPerCtrct"))
            .skip(rs.getInt("Skip"))
            .bSkip(rs.getInt("Skip") == 1)
            .validated(rs.getInt("Validated"))
            .bValidated(rs.getInt("Validated") == 1)
            .complete(rs.getInt("Complete"))
            .bComplete(rs.getInt("Complete") == 1)
            .build();

        return votm;
    }
}
