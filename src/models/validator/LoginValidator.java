package models.validator;

import java.util.ArrayList;
import java.util.List;

import models.User;
import utils.LoginDAO;

public class LoginValidator {


	//ログインフォームで入力した名前とパスワードを
	//バリデーションした結果のエラーメッセージをリスト化するメソッド
	public List<String> loginValidate(String name, String password) {

		//エラーリストを生成
		List<String> error_list = new ArrayList<String>();

		//名前とパスワードが入力されているかバリデーションした結果の
		//エラーメッセージを取得
		String error1 = namePassNullValidate(name, password);
		if(error1.length() > 0) {
			//エラーメッセージがある場合、リストに追加
			error_list.add(error1);
		}

		//名前とパスワードが登録されているかバリデーションした結果の
		//エラーメッセージを取得
		String error2 = namePassDbVaidate(name, password);
		if(error2.length() > 0) {
			//エラーメッセージがある場合、リストに追加
			error_list.add(error2);
		}
		//リストを返す
		return error_list;

	}




	//名前とパスワードが入力されているかチェックするメソッド
	private String namePassNullValidate(String name, String password) {
		if((name == null || name.equals(""))
						&& (password == null || password.equals(""))) {
			//null または　空行の時
			//エラーメッセージを返す
			return "名前またはパスワードを入力してください";

		}
		//空行で返す
		return "";
	}

	//名前とパスワードがDBに登録されているかチェックするメソッド
	private String namePassDbVaidate(String name, String password) {

		//LoginDAOインスタンスの生成
		LoginDAO lu = new LoginDAO();

		User user = lu.logincheck(name, password);

		if(name != user.getUserName() || password != user.getLoginPw()) {

			return "名前またはパスワードが一致しない";
		}

		return "";

	}
}
