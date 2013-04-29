package jp.pokemonms.exception;

/**
 * Datastore登録失敗Exception
 * 
 * @author sinmetal
 *
 */
public class DatastorePutErrorException extends RuntimeException {

    /** シリアルID */
    private static final long serialVersionUID = 1L;

    /** プロパティ */
    protected String property = "error";

    /**
     * デフォルトコンストラクタ
     *
     */
    public DatastorePutErrorException() {
        super();
    };

    /**
     * コンストラクタ
     *
     * @param throwable
     */
    public DatastorePutErrorException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     */
    public DatastorePutErrorException(String message) {
        super(message);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     * @param property
     */
    public DatastorePutErrorException(String message, String property) {
        super(message);
        this.property = property;
    }

    /**
     * プロパティ取得
     *
     * @return
     */
    public String getProperty() {
        return property;
    }

}
