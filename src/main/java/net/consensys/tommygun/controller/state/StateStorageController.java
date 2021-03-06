package net.consensys.tommygun.controller.state;

import net.consensys.tommygun.api.state.DeployStateStorageContractResponse;
import net.consensys.tommygun.api.state.StateStorageAPI;
import net.consensys.tommygun.api.state.StorageContractInfoResponse;
import net.consensys.tommygun.service.storage.StateStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateStorageController implements StateStorageAPI {
  @Autowired StateStorageService stateStorageService;

  @Override
  public DeployStateStorageContractResponse deploy() {
    return new DeployStateStorageContractResponse(stateStorageService.deploySmartContract());
  }

  @Override
  public StorageContractInfoResponse getStorageContractInfo() throws Exception {
    return new StorageContractInfoResponse(stateStorageService.getStorageContractInfo());
  }

  @Override
  public StorageContractInfoResponse getStorageContractInfo(final String address) throws Exception {
    return new StorageContractInfoResponse(stateStorageService.getStorageContractInfo(address));
  }
}
