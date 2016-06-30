package cn.zjf.book.model;

/**
 * Created by zjf 2016-6-25ионГ10:56:01
 * 
 * @param <AsyncCallBack>
 */
public interface IStoreModel extends IModel {

	void loadHotBook(AsyncCallBack callBack);

	void loadNewBook(AsyncCallBack callBack);

	void loadRecommendBook(AsyncCallBack callBack);
}
