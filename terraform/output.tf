output "webapp_url" {
    value = "https://${azurerm_app_service.dev.default_site_hostname}"
}
