package ideamc.titleplugin.Title;

import static ideamc.titleplugin.ColorA.ColorB;
import static ideamc.titleplugin.TitlePlugin.Sql;
import org.bukkit.command.CommandSender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


// /ps create [type] [title名称] [coin/playerpoints/permission]
public class CreateTitle {
    //活动title的创建
    public static void createtitle(CommandSender sender, String type, String titleName, String description){
        String sql = null;
        String Ctitlename = titleName;
        if(titleName.contains("&#")){
            Ctitlename = ColorB(titleName);
        }
        if(type.equalsIgnoreCase("activity")){
            sql = "INSERT INTO Title (type,title_name,description,canbuy,vault,playerpoints,youxiao,sale_end_date) ";
            sql += "VALUES ";
            sql += "('activity',";
            sql += "'" + Ctitlename + "',";
            sql += "'" + description + "',";
            sql += "false,";
            sql += "0,";
            sql += "0,";
            sql += "0,";
            sql += "NULL)";
        }
        if(Sql().query(sql,sender)){
            String sql1 = "SELECT title_id FROM Title";
            sql1 += " WHERE title_name = '" + Ctitlename + "'";
            ResultSet resultSet = Sql().readquery(sql1,sender);
            try {
                if (Objects.requireNonNull(resultSet).next()) {
                    int title_id = resultSet.getInt("title_id");
                    sender.sendMessage("§2[TitlePlugin]创建成功!称号ID为" + title_id);
                }
            } catch (SQLException ignored) {
            }
        }else{
            sender.sendMessage("§4l[TitlePlugin]创建失败!");
        }
    }
    //点券or金币title的创建
    public static void createtitle(CommandSender sender, String type, String titleName, String description, int vault){
        String sql =null;
        String Ctitlename = titleName;
        if(titleName.contains("&#")){
            Ctitlename = ColorB(titleName);
        }
        if(type.equalsIgnoreCase("coin")){
            sql = "INSERT INTO Title (type,title_name,description,vault,canbuy,playerpoints,youxiao,sale_end_date) ";
            sql += "VALUES ";
            sql += "('coin',";
            sql += "'" + titleName + "',";
            sql += "'" + description + "',";
            sql += vault + ",";
            sql += "true,";
            sql += "0,";
            sql += "0,";
            sql += "NULL)";
        } else if(type.equalsIgnoreCase("points")){
            sql = "INSERT INTO Title (type,title_name,description,playerpoints,canbuy,vault,youxiao,sale_end_date) ";
            sql += "VALUES ";
            sql += "('points',";
            sql += "'" + titleName + "',";
            sql += "'" + description + "',";
            sql += vault + ",";
            sql += "true,";
            sql += "0,";
            sql += "0,";
            sql += "NULL)";
        }
        if(Sql().query(sql,sender)){
            String sql1 = "SELECT title_id FROM Title";
            sql1 += " WHERE title_name = '" + Ctitlename + "'";
            ResultSet resultSet = Sql().readquery(sql1,sender);
            try {
                if (Objects.requireNonNull(resultSet).next()) {
                    int title_id = resultSet.getInt("title_id");
                    sender.sendMessage("§2[TitlePlugin]创建成功!称号ID为" + title_id);
                }
            } catch (SQLException ignored) {
            }
        }else{
            sender.sendMessage("§4[TitlePlugin]创建失败!");
        }
    }
    //权限title的创建
    public static void createtitle(CommandSender sender, String type, String titleName, String descripition, String permission){
        String sql =null;
        String Ctitlename = titleName;
        if(titleName.contains("&#")){
            Ctitlename = ColorB(titleName);
        }
        if(type.equalsIgnoreCase("permission")){
            sql = "INSERT INTO Title (type,title_name,description,permission,canbuy,vault,playerpoints,youxiao,sale_end_date) ";
            sql += "VALUES ";
            sql += "('permission',";
            sql += "'" + titleName + "',";
            sql += "'" + descripition + "',";
            sql += "'" + permission + "',";
            sql += "false,";
            sql += "0,";
            sql += "0,";
            sql += "0,";
            sql += "NULL)";
        }
        if(Sql().query(sql,sender)){
            String sql1 = "SELECT title_id FROM Title";
            sql1 += " WHERE title_name = '" + Ctitlename + "'";
            ResultSet resultSet = Sql().readquery(sql1,sender);
            try {
                if (Objects.requireNonNull(resultSet).next()) {
                    int title_id = resultSet.getInt("title_id");
                    sender.sendMessage("§2[TitlePlugin]创建成功!称号ID为" + title_id);
                }
            } catch (SQLException ignored) {
            }
        }else{
            sender.sendMessage("§4[TitlePlugin]创建失败!");
        }
    }
}
