<?php
  
  // Class BitField
  class BitField {
   // protected $roles = array();
    protected $permission;

    public function __construct() {
      $this->setPermission(0);
    }

    public function check($action) {
      if (array_key_exists($action, $this->roles)) {
        print("\n" . $this->roles[$action] . "\n");
        $valueOfPermissionBitwiseAndAction = ($this->permission & $this->roles[$action]);
        print("\n" . $valueOfPermissionBitwiseAndAction . "\n");
	return ($valueOfPermissionBitwiseAndAction > 0);
      }
      return FALSE;
    }
    
    public function add($action) {
      if (array_key_exists($action, $this->roles)) {
        $this->permission |= $this->roles[$action];
        return TRUE;
      }
      return FALSE;
    }
    
    public function remove($action) {
      if (array_key_exists($action, $this->roles)) {
        $this->permission &= ~$this->roles[$action];
        return TRUE;
      }
      return FALSE;
    }
    
    public function setPermission($permission) {
      $this->permission = $permission;
    }
    
    public function getPermission() {
      return $this->permission;
    }
    
    public function getAllRoles() {
      return $this->roles;
    }
  }
  
  // Test
  class Permission extends BitField {
      protected $roles = array(
        'ACTION1' => 1,
        'ACTION2' => 2,
        'ACTION3' => 4,
        'ACTION4' => 8,
        'ACTION5' => 16
      );
  }
  
  $a = new Permission;
  $a->setPermission(18);

  for ($i = 1; $i <= 5; $i++) {
    echo 'ACTION' . $i . ' : ';
    if ($a->check('ACTION' . $i)) {
      echo 'OK' . "\n";
    }
    else {
      echo 'NO :(' . "\n";
    }
  }

