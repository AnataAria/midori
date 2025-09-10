package dev.arisavinh.account.model.dto.request;

public record RegisterAccountRequest(
        String username,
        String password,
        String rePassword
) {
}
