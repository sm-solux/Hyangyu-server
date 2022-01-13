package hyangyu.server.dto;

import lombok.Data;

@Data
public class UserResponseDto {

	private StatusEnum status;
	private String message;
	private Object data;
	private String jwt;
	
	public UserResponseDto() {
		this.status = StatusEnum.BAD_REQUEST;
		this.message = null;
		this.data = null;
		this.jwt = null;
	}
}
