Vagrant.configure(2) do |config|

  config.vm.box = "precise64"
  config.vm.hostname = "vagranthostname"
  config.vm.box = "ubuntu/vivid64"
  # config.vm.box_check_update = false
  # config.vm.network "forwarded_port", guest: 80, host: 8080
  config.vm.network "private_network", ip: "192.168.34.100"
  # config.vm.network "public_network"
  # config.vm.synced_folder "../data", "/vagrant_data"

  #########################################################################################	
  config.vm.provider "virtualbox" do |vb|
	#vb.gui = true
	vb.name = "sprintbootquickstart"
	vb.customize [
		"modifyvm", :id,
		"--groups", "/Vagrant",
		"--ioapic", "on",
		"--memory", "2048",
		"--cpus", "2"
	]
  end
  
  # Define a Vagrant Push strategy for pushing to Atlas. Other push strategies
  # such as FTP and Heroku are also available. See the documentation at
  # https://docs.vagrantup.com/v2/push/atlas.html for more information.
  # config.push.define "atlas" do |push|
  #   push.app = "YOUR_ATLAS_USERNAME/YOUR_APPLICATION_NAME"
  # end

  config.vm.provision "shell", path: "provision-vagrant.sh", privileged: false
  #   sudo apt-get update
  #   sudo apt-get install -y apache2
  # SHELL
end
