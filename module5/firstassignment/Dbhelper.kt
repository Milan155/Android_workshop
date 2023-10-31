package com.example.module_5firstassignment

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Dbhelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="userdata.db"
        var TABLE_NAME="info"
        var ID="id"
        var title="title"
        var task="task"
        var DB_VERSION=1

    }

    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query= "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY," + title + " Text," + task + "Text" + ")"
        p0!!.execSQL(query)
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var upquery = "DROP TABLE if exists " + TABLE_NAME
        p0!!.execSQL(upquery)
        onCreate(p0)
    }
    //for insert your data
    fun insert(m: Model): Long {
        var db = writableDatabase
        var value = ContentValues()

        value.put(task, m.task)
        value.put(title,m.title)

        var Id = db.insert(TABLE_NAME, ID, value)

        return Id


    }

    //view your data
    fun view(): MutableList<Model>{

        var db = readableDatabase

        var list:ArrayList<Model> = ArrayList<Model>()

        var col = arrayOf(ID, title, task)

        var cursor: Cursor = db.query(TABLE_NAME, col, null, null, null, null, null, null)

        while (cursor.moveToNext()) {
            var id = cursor.getInt(0)
            var title = cursor.getString(1)
            var task = cursor.getString(2)

            var m = Model()
            m.id = id
            m.title=title
            m.task = task

            list.add(m)
        }
        return list
    }

    fun delete(Id:Int){
        var db=writableDatabase
        var deletdata= ID+" = " +Id
        db.delete(TABLE_NAME, deletdata,null)
    }

    fun update(m: Model){
        var db=writableDatabase
        var value=ContentValues()
        value.put(ID,m.id)
        value.put(title,m.title)
        value.put(task,m.task)
        var updatedata= ID +"="+m.id
        db.update(TABLE_NAME,value,updatedata,null)
    }
}