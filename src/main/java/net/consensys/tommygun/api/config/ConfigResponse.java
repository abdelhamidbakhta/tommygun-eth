package net.consensys.tommygun.api.config;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.consensys.tommygun.boot.TommyGunConfiguration;

@Getter
@Setter
@NoArgsConstructor
public class ConfigResponse {
  private String rpcUrl;

  @JsonInclude(NON_NULL)
  private Long chainID;

  private String accountCreatorPrivateKey;
  private String stateStorageCreatorPrivateKey;

  @JsonInclude(NON_NULL)
  private String keyValueStoreContractAddress;

  private boolean useSmartContractForAccountCreation;

  @JsonInclude(NON_NULL)
  private String accountCreatorContractAddress;

  private long accountCreatorRetries;

  private long accountCreatorContractSlice;
  private long accountCreatorContractInitialValueEther;

  public ConfigResponse(final TommyGunConfiguration configuration) {
    this.rpcUrl = configuration.getRpcUrl();
    configuration.getChainID().ifPresent(chainID -> this.chainID = chainID);
    this.accountCreatorPrivateKey = configuration.getAccountCreatorPrivateKey();
    this.stateStorageCreatorPrivateKey = configuration.getStateStorageCreatorPrivateKey();
    this.accountCreatorContractSlice = configuration.getAccountCreatorContractSlice();
    this.accountCreatorRetries = configuration.getAccountCreatorRetries();
    this.useSmartContractForAccountCreation = configuration.isUseSmartContractForAccountCreation();
    this.accountCreatorContractInitialValueEther =
        configuration.getAccountCreatorContractInitialValueEther();
    configuration
        .getKeyValueStoreContractAddress()
        .ifPresent(address -> this.keyValueStoreContractAddress = address);
    configuration
        .getAccountCreatorContractAddress()
        .ifPresent(address -> this.accountCreatorContractAddress = address);
  }
}
