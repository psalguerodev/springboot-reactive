package me.psalguero.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown=true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserBean {

	private String name;
	private String blog;

}
