package com.zt.chint_gis.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SecuritycheckDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertcheckBean(SecuritycheckBean...bean);//插入

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updatecheckBean(SecuritycheckBean...bean);//更新

    @Query("select * from security_check")
    SecuritycheckBean[] addAllCheckBeans();//查询全部


}
