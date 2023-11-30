package com.example.mylocationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.location.LocationManager;

import android.location.Criteria;
import android.location.LocationManager;
LocationManager locationManager = (LocationManager) context.getSystemService
        (Context.LOCATION_SERVICE);

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    private static final int REQUEST_LOCATION_PERMISSION = 1;

    // ...

    void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão foi concedida, agora você pode prosseguir com a obtenção de localização
            } else {
                // Permissão foi negada, você deve lidar com a negação
            }
        }
    }
}
    // Criar uma instância de Criteria
    Criteria criteria = new Criteria();
// Definir a precisão
criteria.setAccuracy(Criteria.ACCURACY_FINE); // Para a maior precisão possível
// Ou para a precisão em nível de cidade
// criteria.setAccuracy(Criteria.ACCURACY_COARSE);
// Definir se é necessário altitude
criteria.setAltitudeRequired(false);
// Definir se é necessário suporte a direção
criteria.setBearingRequired(false);
// Definir se pode incorrer em custos monetários
criteria.setCostAllowed(true);
// Definir o consumo de energia desejado
criteria.setPowerRequirement(Criteria.POWER_LOW); // Para baixo consumo de energia
// Ou para alto consumo de energia
// criteria.setPowerRequirement(Criteria.POWER_HIGH);
// Outros critérios podem ser definidos conforme necessário

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


        LocationListener locationListener = new LocationListener() {
public void onLocationChanged(Location location) {
        // Chamado quando uma nova localização é encontrada pelo provedor de localização.
        // Use a nova localização aqui.
        }

public void onStatusChanged(String provider, int status, Bundle extras) {}

public void onProviderEnabled(String provider) {}

public void onProviderDisabled(String provider) {}
        };

@Override
protected void onResume() {
        super.onResume();
        // Certifique-se de verificar as permissões de runtime antes de registrar o listener.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        }

@Override
protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
        }
        }
// Iniciar solicitações de atualização de localização
        long minTime = 1000; // tempo mínimo entre atualizações em milissegundos, ex: 1000ms = 1s
        float minDistance = 10; // distância mínima entre atualizações em metros, ex: 10m

// Verifique as permissões antes de chamar requestLocationUpdates
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        // Usando GPS para atualizações de alta precisão
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, locationListener);

        // Ou usando rede para atualizações de menor precisão
        // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, locationListener);
        }





private final LocationListener locationListener = new LocationListener() {
public void onLocationChanged(Location location) {
        // Nova localização encontrada pelo provedor de localização.
        if (location != null) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        // Agora você tem a latitude e longitude e pode usar como precisar
        // Por exemplo, atualizar a interface do usuário ou enviar para um servidor
        }
        }

public void onStatusChanged(String provider, int status, Bundle extras) {
        // Chamado quando o status do provedor muda
        }

public void onProviderEnabled(String provider) {
        // Chamado quando um provedor é habilitado pelo usuário
        }

public void onProviderDisabled(String provider) {
        // Chamado quando um provedor é desabilitado pelo usuário
        }
        };
@Override
protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        }

@Override
protected void onPause() {
        super.onPause();
        // Parar atualizações para economizar bateria
        locationManager.removeUpdates(locationListener);
        }
        }