package com.example.intentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //画面部品ListViewを取得
        ListView LvMenu =findViewById(R.id.lvMenu);
        //SimpleAdapterで使用するListオブジェクトを用意。
        List<Map<String,String>> menuList =new ArrayList<>();
        //唐揚げ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        Map<String,String>menu=new HashMap<>();
        menu.put("name","からあげ定食");
        menu.put("price","800円");
        menuList.add(menu);
        menu=new HashMap<>();
        //ハンバーグ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu.put("name","ハンバーグ定食");
        menu.put("price","850円");
        menuList.add(menu);
        menu=new HashMap<>();
        menu.put("name","まぐろ定食");
        menu.put("price","750円");
        menuList.add(menu);
        menu=new HashMap<>();
        menu.put("name","コロッケ定食");
        menu.put("price","600円");
        menuList.add(menu);
        menu=new HashMap<>();
        menu.put("name","さば定食");
        menu.put("price","650円");
        menuList.add(menu);
        menu=new HashMap<>();
        menu.put("name","生姜焼き定食");
        menu.put("price","700円");
        menuList.add(menu);

      //SimpleAdapter第4引数form用データの用意
       String[] form={"name","price"};
       //SimpleAdapter第5引数to用データの用意。
        int[] to={android.R.id.text1,android.R.id.text2};
        //SimpleAdapterを生成。
        SimpleAdapter addpter=new SimpleAdapter(MenuListActivity.this,menuList,android.R.layout.simple_list_item_2,form,to);
        //アダプタの登録
        LvMenu.setAdapter(addpter);
        LvMenu.setOnItemClickListener(new ListItemClickListener())  ;
    }
    //リストがタップされたときのメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?>parent, View view,int position,long id){
            //タップされた行のデータを取得。SimpleAdapterでは一行分のデータはMap型
            Map<String,String>item=(Map<String,String>)parent.getItemAtPosition(position);
            //定食名と金額を取得
            String menuName=item.get("name");
            String menuPrice=item.get("price");
            //インテントオブジェクトを生成
            Intent intent=new Intent(MenuListActivity.this,MenuThanksActivity.class);
            intent.putExtra("menuName",menuName);
            intent.putExtra("menuPrice",menuPrice);
            //第二画面の起動
            startActivity(intent);
        }
    }

}
