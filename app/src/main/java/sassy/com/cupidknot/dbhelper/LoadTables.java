package sassy.com.cupidknot.dbhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;


import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import sassy.com.cupidknot.extras.Keys;

public class LoadTables {


    public LoadTables(Context context)
    {
        db = dbhelper.getInstance(context);

    }
	private static dbhelper db;
	public Context context;

	static final LinkedHashMap<String, String> fields = new LinkedHashMap<>();
	public void LoadAllTables(Context context) {

		db = dbhelper.getInstance(context);
       	this.context = context;
        init();

	}


	public void init() {

		try {

            initUser();

		} catch (SQLException e) {
			e.printStackTrace();
			/*AlertDialogManager.showAlertDialog(context, "Database Error",
					"Database Error Occured");*/
		}
	}

    private void initUser() {
	    fieldUser();
	    CreateTable(Keys.TblUser,"");
    }


    public static LinkedHashMap<String, String> fieldUser() {
        fields.clear();
        fields.put(Keys.userid, "TEXT");
        fields.put(Keys.name, "TEXT");
        fields.put(Keys.email, "TEXT");
        fields.put(Keys.profilePic, "TEXT");
        fields.put(Keys.JwtToekn, "TEXT");
        fields.put(Keys.profile_id, "TEXT");
        fields.put(Keys.profile_name, "TEXT");

        return fields;
    }


    private void CreateTable(String $tablename, String primarykey) {
        String sql = dbhelper.createTable($tablename, fields, primarykey);
        dbhelper.executeSql(sql);
    }


    public void getDeleteLikes(String tablename)
    {
        dbhelper.executeSql("delete from "+tablename+" where userid=1");
    }

    public void insertData(String tablename, String primarykey, List<String> lst, LinkedHashMap<String, String> fields)
    {
       dbhelper.insertTable(tablename,fields,primarykey,lst);
    }

    public static void deleteTable(String tablename)
    {
       dbhelper.executeSql("delete from "+tablename);
        //ShowToast.Show(""+trues);
    }
    public void deleteTable(String tablename, String where, String wherepara)
    {
        dbhelper.executeSql("delete from "+tablename+ " where "+where+" = "+wherepara);
    }



  /*  public int getMaxAppid()
    {
        Cursor c1=db.makeQuery("select Max("+Keys.appid+") from "+Keys.TblRowColumn);
        while (c1.moveToNext()) {
            return c1.getInt(0)+1;
        }
        return 0;
    }
*/

    public void execSql(String qry)
    {
        dbhelper.executeSql(qry);
    }
    public static ArrayList<String[]> getData(String tablename) {
        return db.getData(tablename);
    }

    public static ArrayList<String[]> getDatabyqry(String qry) {
        return db.getDatabyqry(qry);
    }

    public static int getCount(String tablename, String Where, String paraWhere)
    {
       return db.getCount(tablename,Where,paraWhere);
    }
    public static int getCount(String tablename)
    {
        return db.getCount(tablename);
    }


    public static String getEmailId()
    {
        Cursor c=db.makeQuery("select * from "+Keys.TblUser);
        while (c.moveToNext())
        {
            return c.getString(2);
        }
        return  "";

    }

    public static  int getIsActive()
    {
        Cursor c=db.makeQuery("select * from "+Keys.TblUser);
        while (c.moveToNext())
        {
            return c.getInt(7);
        }
        return  0;

    }

    public static String getAuthToken()
    {
        Cursor c=db.makeQuery("select * from "+Keys.TblUser);
        while (c.moveToNext())
        {
            return c.getString(4);
        }
        return  "";

    }


}
