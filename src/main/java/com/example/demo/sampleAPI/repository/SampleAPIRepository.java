package com.example.demo.sampleAPI.repository;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sampleAPI.data.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SampleAPIRepository {

	public Animals[] getAnimals() throws IOException {
		//動物情報一覧APIのＵＲＬ
		  String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
		  //Rest通信(Api呼び出し)にかかわるメソッド利用の為にnew
		  RestTemplate rest = new RestTemplate();
		  /*
		   * getForEntity.....URLとレスポンスボディを引数に渡して、ResponseEntityオブジェクト(中身)を取得するメソッド
		   * url....APIのURL
		   * String.class....レスポンスボディのタイプ指定。今回はString(文字列)型で受け取る。右の.classで指定した型で戻り値が帰ってくる？
		   */
		  ResponseEntity<String> response = rest.getForEntity(url, String.class);

		  System.out.println("\nresponse変数の中身↓\n" + response);
		  //取得したオブジェクトから、必要な部分だけ抜き出す。jsonという変数に入れている。
		  String json = response.getBody();

		  System.out.println("\njson変数の中身↓\n" + json);
		  //mapperクラスの利用の為new
		  ObjectMapper mapper = new ObjectMapper();
		  //JSON文字列をデシリアライズして配列に格納. Json→オブジェクトに変換する感じ
		  Animals[] animalsList = mapper.readValue(json, Animals[].class);

		  System.out.println("\n配列の中身↓\n" + Arrays.toString(animalsList));
		  //配列をリターン
		  return animalsList;
	}

}
