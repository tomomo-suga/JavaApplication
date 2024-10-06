import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * グラフィカルユーザーインターフェース（GUI）を備えたサンプルクラス。
 */
public class GuiSample extends JFrame implements ActionListener {

	/** ウィンドウのサイズ指定(幅, 高さ) */
	private final Dimension FS = new Dimension(500, 300);
	/** ボタンの文字列の定義 */
	private final String[] str = { "Start", "Clear", "Exit" };
	/** ボタンオブジェクト配列への参照を定義 */
	private final JButton[] bt = new JButton[str.length];
	/** コンボボックスのアイテム（文字列）の定義 */
	private final String[] item = { "日付けの取得", "時刻の取得" };
	/** トップレベルコンテナの参照 */
	private Container cp = null;
	/** コンボボックスへの参照を定義 */
	private JComboBox<String> cb;
	/** タイムゾーン型インスタンスを生成 */
	private final TimeZone tz = TimeZone.getTimeZone("JST");
	/** グラフィックスオブジェクトへの参照を定義 */
	private Graphics g;
	/** コンボボックスの選択項目の保存用 */
	private String it = item[0];
	/** 画面に表示する文字列の保存用 */
	private String save = "";

	/**
	 * メインメソッド
	 * 
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		new GuiSample("コンボボックス使用例");
	}

	/**
	 * コンストラクタ
	 * 
	 * @param title ウィンドウのタイトル
	 */
	public GuiSample(String title) {
		super(title);
		setSize(FS);

		cp = getContentPane();
		cp.setBackground(Color.yellow);
		cp.setLayout(new FlowLayout(FlowLayout.LEFT));
		cp.add(new JLabel("どちらか選んでください"));

		cb = new JComboBox<>(); // コンボボックスのインスタンス生成
		cb.setEditable(false); // コンボボックスに，文字入力できないように設定

		for (String name : item) { // コンボボックスにアイテム（文字配列）を登録
			cb.addItem(name);
		}

		cb.addActionListener(this); // コンボボックスをActionListenerに登録

		cp.add(cb); // トップレベルコンテナにコンボボックスを貼り付ける

		for (int i = 0; i < str.length; i++) {
			bt[i] = new JButton(str[i]); //ボタンのインスタンスを生成（ボタンに貼る文字列を指定して...）
			bt[i].addActionListener(this); // ボタンをActionListenerに登録
			cp.add(bt[i]); // コンテンツペイン（コンテナ）にボタンを登録
		}
		setVisible(true); // ウィンドウ画面を表示（この記述場所に注意！）

		g = cp.getGraphics(); // グラフィックスオブジェクトへの参照を取得

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // アプリケーションの正常終了用
	}

	/**
	 * paint メソッドのオーバーライド
	 * 
	 * @param g グラフィックスオブジェクト
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g = cp.getGraphics();
		if (save.contains("/")) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); // フォント設定
			g.setColor(Color.red); // 文字色の設定
			g.drawString(save, 40, 190); // 日にちの描画

		} else {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
			g.setColor(Color.blue); // 文字色の設定
			g.drawString(save, 60, 190); // 時刻の描画
		}
	}

	/**
	 * ActionListerner インターフェイスのメソッドを実装
	 * 
	 * @param evt ActionEvent イベントオブジェクト
	 */
	@Override
	public void actionPerformed(ActionEvent evt) { // 何かウィンドウに対してユーザーがアクションを起こしたら...
		Object source = evt.getSource(); // イベントを発生した源を取得
		cp.update(g); // この１行が非常に大切

		if (source == cb) { // もし，アクションの発生源がコンボボックスなら....
			it = (String) cb.getSelectedItem(); // コンボボックスに登録されたアイテム（文字列）を並べて表示せよ
		} else if (source == bt[0]) { // もし，アクションの発生源がボタン０なら....
			Calendar cl = Calendar.getInstance(tz); // カレンダーオブジェクトを生成せよ
			if (it == item[0]) { // もし選択された文字列が"日付けの取得"なら，
				int year = cl.get(Calendar.YEAR);
				int month = cl.get(Calendar.MONTH);
				month++;
				int date = cl.get(Calendar.DATE);
				String s_year, s_month, s_date;
				s_year = "" + year;
				if (month < 10) {
					s_month = "0" + month;
				} else {
					s_month = "" + month;
				}
				if (date < 10) {
					s_date = "0" + date;
				} else {
					s_date = "" + date;
				}
				g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); // フォント設定
				g.setColor(Color.red); // 文字色の設定
				g.drawString(s_year + "/" + (s_month) + "/" + s_date, 40, 190); // 日にちの描画
				save = s_year + "/" + (s_month) + "/" + s_date; // 文字列の保存
			} else if (it == item[1]) { // もし選択された文字列が"時刻の取得"なら，
				int hr = cl.get(Calendar.HOUR_OF_DAY);
				int min = cl.get(Calendar.MINUTE);
				int sec = cl.get(Calendar.SECOND);
				String s_hr, s_min, s_sec;
				if (hr < 10) {
					s_hr = "0" + hr;
				} else {
					s_hr = "" + hr;
				}
				if (min < 10) {
					s_min = "0" + min;
				} else {
					s_min = "" + min;
				}
				if (sec < 10) {
					s_sec = "0" + sec;
				} else {
					s_sec = "" + sec;
				}
				g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
				g.setColor(Color.blue); // 文字色の設定
				g.drawString(s_hr + ":" + s_min + ":" + s_sec, 60, 190); // 時刻の描画
				save = s_hr + ":" + s_min + ":" + s_sec; // 文字列の保存
			}
		} else if (source == bt[1]) { // もし，アクションの発生源がボタン１なら....
			save = ""; // この１行も重要！
			repaint(); // 画面のクリヤー
		} else if (source == bt[2]) { // もし，アクションの発生源がボタン２なら....
			dispose(); // グラフィックスオブジェクトへの参照を破棄
			System.exit(0); // 画面を閉じる
		}
	}
}