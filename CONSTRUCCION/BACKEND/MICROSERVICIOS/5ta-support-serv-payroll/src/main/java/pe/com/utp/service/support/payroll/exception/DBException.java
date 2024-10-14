package pe.com.utp.service.support.payroll.exception;

public class DBException extends BaseException {

	public DBException(String code, String message, Throwable exception) {
		super(code, message, exception);
	}
}