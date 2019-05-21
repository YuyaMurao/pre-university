/**
* プログラム名：住所表示プログラム 
* 作成者：村尾侑哉
* 完成日：2017/02/06
*/

import java.util.Scanner;

public class itiran {
	static String[] name,jusyo;	//名前と住所を記録するために用意。
	static int password = 0;	//パスワードを用意
	static Scanner sc = new Scanner(System.in);	//キーボードからの入力を受け付ける準備

	public static void main(String[] args) {
		menu();	//メニューの実行
	}

	//メニュー
	public static void menu(){
		int num,flg = 0;	//num:メニューで何をしたいか識別する。   flg:ループから抜けるか否かの判断
		
		System.out.println("＊＊＊住所表示プログラム＊＊＊");	//プログラムの名前
		
		while(flg == 0){	//flgが0のときは選択でき、1になると終了する
			//モード選択
			System.out.println("1：初期入力モード、2：一覧表示モード、3：パスワード設定、4：終了");
			System.out.println("数字を入力してください");
			System.out.print("＞＞");
			num = sc.nextInt();

			switch (num){	//数字で判断(１～４までの数字)
			case 1:	//入力処理
				syokika();	//配列の要素数を決めるための初期化処理
				nyu();
				flg = 1;	//flgを1にしてループを抜け、終了させる
				break;
			case 2:	//一覧表示処理
				if(name == null){	//データを何も入力していない場合
					System.out.println("！データがありません！");
					break;
				}else if(password == 0){	//パスワードの設定を行っていない場合
					System.out.println("！パスワードの設定を行ってください！");
					System.out.print("↓メニューへ戻ります↓");
					menu();
					flg = 1;	//flgを1にしてループを抜け、終了させる
					break;
				}
				System.out.println("パスワードを入力してください");
				System.out.print("＞＞");
				int nyuryokupass;
				nyuryokupass = sc.nextInt();
				if(password != nyuryokupass){	//パスワードが一致しない場合
					System.out.println("パスワードが違います");
					System.out.print("↓メニューへ戻ります↓");
					menu();
					flg = 1;	//flgを1にしてループを抜け、終了させる
					break;
				}
				syutu();
				flg = 1;	//flgを1にしてループを抜け、終了させる
				break;
			case 3:	//パスワード設定処理
				pass();
				flg = 1;	//flgを1にしてループを抜け、終了させる
				break;
			case 4:	//終了させる
				System.out.println("！終了します！");
				flg = 1;	//flgを1にしてループを抜け、終了させる
				break;
			default:	//入力したものが該当しない場合は入力エラーとし、数字を再入力させる
				System.out.println("！入力エラー！");
				System.out.println("数字を入力しなおしてください。");
			}
		}
	}
	
	//初期化処理
	public static void syokika(){
		//nameとjusyoのそれぞれに名前と住所を記憶させるため0～100までの配列にする
		name = new String[100];
		jusyo = new String[100];
	}
	
	//入力処理
	public static void nyu(){
		System.out.println("＊入力モード＊");
		int flg = 1,ninzu = 1;	//flgは処理を終了させるためのフラグ,ninzuは人数を表す
		System.out.println("ここでは入力作業を行います。");
		System.out.println("名前・住所を入力して登録します。（100人まで）");
		while(flg == 1){	//flgが1の間はループします。2かそれ以外の場合は終了します
			System.out.println("～"+ ninzu +"人目入力中～");	//今何人目を入力しているのか分かるように表示させる
			System.out.print("名前＞＞");
			name[ninzu] = sc.next();	//キーボードから取得した名前をnameの(人数)番目へ格納
			System.out.print("住所＞＞");
			jusyo[ninzu] = sc.next();	//キーボードから取得した住所をjusyoの(人数)番目へ格納
			System.out.println("～" + ninzu +"人目入力完了～");	//今何人目を入力したのか分かるように表示させる
			System.out.println("まだ入力しますか？");	//入力の継続を問う
			System.out.println("1:まだ入力する、2:もう終了する");
			System.out.print("＞＞");
			flg = sc.nextInt();	//キーボードから取得した数字をflgへ入れる
			ninzu ++;	//人数をプラスさせる
			if (ninzu == 101){	//100人を超える場合は入力をストップさせる
				System.out.println("１００人なのでこれ以上入力できません。");
				flg = 2;	//フラグを2にしてループを終了させる
			}
		} 
		System.out.println("↓メニューへ戻ります↓");	//一通り処理を終えるとメニューへ戻らせる
		menu();
    }
	
	//一覧出力処理
	public static void syutu(){
		System.out.println("＊一覧表示モード＊");
	    System.out.println("ここでは名前が表示されます。");
	    int kazu = 1,suu;	//kazuは出力処理のために使い、suuは目的の番号を代入するための変数
	    while(name[kazu] != null){	//一覧出力：データが入ってる分だけ名前を出力していきます
	    	System.out.println(kazu + "."+ name[kazu]);	//出力例⇒1.村尾侑哉
	    	kazu ++;									//	      2.村尾？？
	    }
	    System.out.println("住所を知りたい場合はその人の番号を入力してください。");
	    int flg =1;	//フラグが１の間は閲覧できる
	    while(flg == 1){
	    	//目的の番号を聞き出し、名前と住所を表示する
	    	System.out.print("番号＞＞");
	    	suu = sc.nextInt();
	    	System.out.println("名前:" + name[suu] + "   " + "住所：" + jusyo[suu]);
	    	System.out.println("続けて閲覧しますか？");	//フラグが１だともう一度同じ処理
	    	System.out.println("1：はい、2：いいえ");
	    	System.out.print("＞＞");
	    	flg = sc.nextInt();
	    }
		System.out.println("↓メニューへ戻ります↓");	//一通り処理を終えるとメニューへ戻らせる
		menu();
	}

	//パスワード設定処理
	public static void pass(){
	    System.out.println("ここではパスワードの設定を行います。");
	    System.out.println("設定を行いますか？");
	    System.out.println("１：はい、２：いいえ");
	    System.out.print("＞＞");
	    int flg;	//flgが１の場合はパスワード設定を行う
	    flg = sc.nextInt();
	    if(flg == 1){
	    	System.out.println("＊パスワード設定＊");
	    	System.out.println("！パスワードは全て数字で設定してください！");
	    	System.out.println("！パスワードは0以外で設定してください！");
	    	int karipass,kakuninpass,nyuryokupass;	//仮パスワード、確認パスワード、入力されたパスワードの事
	    	System.out.println("今のパスワードを入力してください（初期値は0です）");
	    	System.out.print("＞＞");
	    	nyuryokupass = sc.nextInt();
	    	if(password == nyuryokupass){	//入力されたパスワードが本当のパスワードと合致する場合
	    		System.out.println("合致しました。");
	    		System.out.println("新しいパスワードを入力してください。");
	    		System.out.print("＞＞");
	    		karipass = sc.nextInt();
	    		System.out.println("再確認のためもう一度入力してください");
	    		System.out.print("＞＞");
	    		kakuninpass = sc.nextInt();
	    		if(karipass == kakuninpass){	//仮パスワードと確認パスワードが同じ場合は本当のパスワードにする
	    			password = karipass;
	    			System.out.println("設定が完了したのでメニューへ戻ります。");
	    			menu();
	    		}else{	//仮パスワードと確認パスワードが合致しなかった場合
	    			System.out.println("合致しなかったので再度設定しなおしてください。");
	    			System.out.println("戻ります。");
	    			pass();
	    		}
	    	}else{	//入力されたパスワードが本当のパスワードと合致しなかった場合
	    		System.out.println("合致しなかったのでメニューへ戻ります");
	    		menu();
	    	}
	    }else{
	    	menu();
	    }
	}
}