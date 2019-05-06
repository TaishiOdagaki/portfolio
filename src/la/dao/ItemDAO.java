package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CategoryBean;
import la.bean.ItemBean;

public class ItemDAO {
	private Connection con;

	public ItemDAO() throws DAOException {
		getConnection();
	}

	public List<CategoryBean> findAllCategory() throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM category ORDER BY code";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<CategoryBean> list = new ArrayList<CategoryBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				CategoryBean bean = new CategoryBean(code, name);
				list.add(bean);
			}
			// カテゴリ一覧をListとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public List<ItemBean> findByCategory(int categoryCode)
												throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql =
					"SELECT * FROM item WHERE category_code = ? ORDER BY code";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
			st.setInt(1, categoryCode);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String image = rs.getString("image");
				ItemBean bean = new ItemBean(code, name, price, image);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public ItemBean findOne(int key) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM item WHERE code = ?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
			st.setInt(1, key);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			if (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int level = rs.getInt("level");
				int popularity = rs.getInt("popularity");
				String image = rs.getString("image");
				String information = rs.getString("information");
				ItemBean bean = new ItemBean(code, name, price, level, popularity, image, information);
				return bean;
			} else {
				return null; // 主キーに該当するレコードなし
			}
			// 商品一覧をListとして返す
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	public List<ItemBean> findAll(int key) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM item ORDER BY code LIMIT 5 OFFSET 5*(?-1)";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setInt(1, key);
			// SQＬの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int level = rs.getInt("level");
				int popularity = rs.getInt("popularity");
				String information = rs.getString("information");
				String image = rs.getString("image");
				ItemBean bean = new ItemBean(code, name, price, level, popularity, information, image);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました・・・");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました・・・");
			}
		}
	}


	 public ItemBean findLucky() throws DAOException{
	    	if(con == null)
	    		           getConnection();

		    PreparedStatement st = null;
	 	    ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM item ORDER BY RANDOM() LIMIT 1";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
//			st.setInt(1, key);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			if (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String image = rs.getString("image");
				ItemBean bean = new ItemBean(code, name, price, image);
				return bean;

           }else {
           	return null;
           }

			// 商品一覧をListとして返す
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	
	
	private void getConnection() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			// URL、ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:sample";
			String user = "postgres";
			String pass = "taishi1985";
			// データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

///////////ここから書き換え。243ページより。


		public List<ItemBean> findByPopularity(int lePopularity) throws DAOException {
			if (con == null)
				getConnection();

			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				// SQL文の作成
				String sql = "SELECT * FROM item WHERE popularity >= ?";
				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// 値段のセット
				st.setInt(1, lePopularity);
				// SQLの実行
				rs = st.executeQuery();
				// 結果の取得および表示
				List<ItemBean> list = new ArrayList<ItemBean>();
				while (rs.next()) {
					int code = rs.getInt("code");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int level = rs.getInt("level");
					int popularity = rs.getInt("popularity");
					String information = rs.getString("information");
					String image = rs.getString("image");
					ItemBean bean = new ItemBean(code, name, price, level, popularity, information, image);
					
				list.add(bean);
				}
				
				// 商品一覧をListとして返す
				return list;
				}catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			} finally {
				try {
					// リソースの開放
					if(rs != null) rs.close();
					if(st != null) st.close();
					close();
				} catch (Exception e) {
					throw new DAOException("リソースの開放に失敗しました。");
				}
			}
		}
		public List<ItemBean> sortLevel(boolean isAscending) throws DAOException {
			if (con == null)
				getConnection();

			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				// SQL文の作成
				String sql;
				// ソートキーの指定
				if(isAscending)
					sql = "SELECT * FROM item ORDER BY level";
				else
					sql = "SELECT * FROM item ORDER BY level desc";

				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// SQLの実行
				rs = st.executeQuery();
				// 結果の取得および表示
				List<ItemBean> list = new ArrayList<ItemBean>();
				if (rs.next()) {
					int code = rs.getInt("code");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int level = rs.getInt("level");
					int popularity = rs.getInt("popularity");
					String information = rs.getString("information");
					String image = rs.getString("image");
					ItemBean bean = new ItemBean(code, name, price, level, popularity, information, image);
					
					list.add(bean);
				}
				// 商品一覧をListとして返す
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			} finally {
				try {
					// リソースの開放
					if(rs != null) rs.close();
					if(st != null) st.close();
					close();
				} catch (Exception e) {
					throw new DAOException("リソースの開放に失敗しました。");
				}
			}
		}

		public List<ItemBean> sortPopularity(boolean isAscending) throws DAOException {
			if (con == null)
				getConnection();

			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				// SQL文の作成
				String sql;
				// ソートキーの指定
				if(isAscending)
					sql = "SELECT * FROM item ORDER BY popularity";
				else
					sql = "SELECT * FROM item ORDER BY popularity desc";
				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// SQLの実行
				rs = st.executeQuery();
				// 結果の取得および表示
				List<ItemBean> list = new ArrayList<ItemBean>();
				while (rs.next()) {
						int code = rs.getInt("code");
						String name = rs.getString("name");
						int price = rs.getInt("price");
			
						String image = rs.getString("image");
						ItemBean bean = new ItemBean(code, name, price, image);
						
					list.add(bean);
				}
				// 商品一覧をListとして返す
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			} finally {
				try {
					// リソースの開放
					if(rs != null) rs.close();
					if(st != null) st.close();
					close();
				} catch (Exception e) {
					throw new DAOException("リソースの開放に失敗しました。");
				}
			}
		}
		public int addItem(int code ,String name, int popularity, int level) throws DAOException {
			if (con == null)
				getConnection();

			PreparedStatement st = null;
			try {
				// SQL文の作成
				String sql = "INSERT INTO item(code,name, popularity, level) VALUES(?, ?,?,?)";
				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// ソートキーの指定
				st.setInt(1, code);
				st.setString(2,  name);
				st.setInt(3,popularity);
				st.setInt(4,level);
				// SQLの実行
				int rows = st.executeUpdate();
				return rows;
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("レコードの操作に失敗しました。");
			} finally {
				try {
					// リソースの開放
					if(st != null) st.close();
					close();
				} catch (Exception e) {
					throw new DAOException("リソースの開放に失敗しました。");
				}
			}
		}

			public List<ItemBean> findByLevel(int lelevel) throws DAOException {
				if (con == null)
					getConnection();

				PreparedStatement st = null;
				ResultSet rs = null;
				try {
					// SQL文の作成
					String sql = "SELECT * FROM item WHERE level <= ?";
					// PreparedStatementオブジェクトの取得
					st = con.prepareStatement(sql);
					// 値段のセット
					st.setInt(1, lelevel);
					// SQLの実行
					rs = st.executeQuery();
					// 結果の取得および表示
					List<ItemBean> list = new ArrayList<ItemBean>();
					while (rs.next()) {
						while (rs.next()) {
								int code = rs.getInt("code");
								String name = rs.getString("name");
								int price = rs.getInt("price");
								String image = rs.getString("image");
								ItemBean bean = new ItemBean(code, name, price, image);
								
						list.add(bean);
					}
					}
					// 商品一覧をListとして返す
					return list;
					}catch (Exception e) {
					e.printStackTrace();
					throw new DAOException("レコードの操作に失敗しました。");
				} finally {
					try {
						// リソースの開放
						if(rs != null) rs.close();
						if(st != null) st.close();
						close();
					} catch (Exception e) {
						throw new DAOException("リソースの開放に失敗しました。");
					}
				}
		}
		}







	

