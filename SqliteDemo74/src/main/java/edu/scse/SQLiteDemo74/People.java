package edu.scse.SQLiteDemo74;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class People {
    public int ID = -1;
    public String Name;

    public int Age;
    public float Height;

    @Override
    public String toString() {
        String result = "";
        result += "ID：" + this.ID + "，";
        result += "姓名：" + this.Name + "，";
        result += "年龄：" + this.Age + "， ";
        result += "身高：" + this.Height + "，";
        return result;
    }
}
