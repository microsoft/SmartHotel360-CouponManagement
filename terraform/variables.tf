variable "azure" {
  description = "Configuration of the target Azure environment. Keys: resource_group_name, resource_name and location." 
  type        = "map"
}

variable "acr" {
  description = "The host, credentials, repository and tag of the Azure Container Registry. Keys: host, username, password, repository and tag."
  type        = "map"
}

variable "mysql" {
  description = "Database name and credentials of the MySQL server. Keys: database, username and password."
  type        = "map"
}
