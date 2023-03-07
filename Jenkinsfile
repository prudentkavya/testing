pipeline {
  agent any
  
  stages {
    stage('Checkout') {
      steps {
        git branch: 'main',url: 'https://github.com/prudentkavya/testing.git'
      }
    }
    
    stage('Build') {
      steps {
        sh 'npm install'
        sh 'npm run build'
      }
    }
    
    stage('Deploy') {
      environment {
        AZURE_SUBSCRIPTION_ID = 'ede17615-7133-45ce-b136-5447fb695159'
        AZURE_CLIENT_ID ='80876e05-ec87-4806-8d50-7422341ddd20'
        AZURE_CLIENT_SECRET ='23ff46af-8947-4037-b4a3-41564f1a6c10'
        AZURE_TENANT_ID ='4161060e-3bfd-44d1-a481-d7aec2185c39'
        AZURE_VM_RESOURCE_GROUP = 'ds_rg'
        AZURE_VM_NAME = 'nifi-1'
        AZURE_VM_USER = 'azureuser'
        AZURE_VM_SSH_KEY = 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQD1gEVdFSYFdeZO53pTzvnmKxPWHu2MtQbZEPUkBQMSpa7bVq3+AM8nedZkPZPzEHUXVj7qf3q6Bg2qDcAQgBf5bZGht2/KDl4Ka8pg2Z/5Oq7K3uuHOlnCBsGFbUEL/dSHAZ88gUZiz5Hto99I6mtg5Vem9EDPc8XP2cJLApz9w/qjjRQzR+uWrQsKNNDXMzcvDv6n30WlouBIH2ZZevWSkiYRfOQrGSdOO26aVj+GF3P1yoOmyeCRcpxkUuwuZ6jMIPNOVV20m1zJIA8EUJYUY7+W/BzKEYjiIepkWKfjC04a6kv+FwORjHu9FeeDI22Iuu0/Ywid53pLwuI3n4fj4Rma6JTDYDCr+IyfRZkZPM36r9znpF3TfyFkRCcfmn2luEkv7uy0XIIcstMuR2FahIoD/hs/s92DpXsQbdapHjDiI8bHmrzrRwLQ4DOIA82qDQHcsFUaQ5QevkmTxLnM74QWGgvIMZEKY4gZkdN6wux79iraXYb70QLn2de6tLk= generated-by-azure'
      }
      
      steps {
        sh 'az login --service-principal --username $AZURE_CLIENT_ID --password $AZURE_CLIENT_SECRET --tenant $AZURE_TENANT_ID'
        sh 'az vm extension set --publisher Microsoft.Azure.Extensions --version 2.0 --name CustomScript --vm-name $AZURE_VM_NAME --resource-group $AZURE_VM_RESOURCE_GROUP --settings \'{"commandToExecute": "sudo sh /home/azureuser/deploy.sh"}\''
      }
    }
  }
}
