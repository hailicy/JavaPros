package club.imgurl.common;

import java.io.Serializable;

public class ResponseResult implements Serializable {

	private static final long serialVersionUID = -6719552454006038350L;

	private boolean success;
	private int code;
	private String message;
	private Object data;

	public ResponseResult() {
	}

	public ResponseResult(boolean success, int code, String message, Object data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseResult success() {
		this.message = "success";
		this.code = 200;
		this.success = true;
		return this;
	}

	public ResponseResult success(String message) {
		this.message = message;
		this.code = 200;
		this.success = true;
		return this;
	}

	public ResponseResult success(String message, Object data) {
		this.message = message;
		this.data = data;
		this.code = 200;
		this.success = true;
		return this;
	}

	public ResponseResult fail() {
		this.message = "fail";
		this.code = -1;
		this.success = false;
		return this;
	}

	public ResponseResult fail(String message) {
		this.message = message;
		this.code = -1;
		this.success = false;
		return this;
	}

	public ResponseResult fail(String message, Object data) {
		this.message = message;
		this.data = data;
		this.code = -1;
		this.success = false;
		return this;
	}

	public ResponseResult build() {
		return new ResponseResult(success, code, message, data);
	}

	public boolean isSuccess() {
		return success;
	}

	public ResponseResult success(boolean success) {
		this.success = success;
		return this;
	}

	public int getCode() {
		return code;
	}

	public ResponseResult code(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseResult message(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResponseResult data(Object data) {
		this.data = data;
		return this;
	}

}
