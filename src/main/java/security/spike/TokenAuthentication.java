package security.spike;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class TokenAuthentication extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -5672561287284846108L;

	private String principal;
	private String credentials;

	public TokenAuthentication(String token) {
		super(null);
		this.principal = token;
		this.credentials = token;
		setAuthenticated(false);
	}
	
	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}
}
