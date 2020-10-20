package com.example.ex018;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener{
    Spinner land,country;
    ListView city;
    TextView pop,area;

    String [] [] cities= new String [29][5];
    String [][] facts= new String [140][2];
    int opc,opl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        land=(Spinner) findViewById(R.id.land);
        country=(Spinner)findViewById(R.id.country);
        city=(ListView) findViewById(R.id.city);
        pop=(TextView) findViewById(R.id.pop);
        area=(TextView) findViewById(R.id.area);

        fillIn(cities,facts);

        land.setOnItemSelectedListener(this);
        country.setOnItemSelectedListener(this);

        city.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        city.setOnItemClickListener(this);

        ArrayAdapter<String> lan= new ArrayAdapter<String>(this,R.layout.
                support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.lands));
        land.setAdapter(lan);
    }

    private void fillIn(String[][] cities, String[][] facts) {
        cities[0][0]="Brasília";cities[0][1]="Rio de Janeiro";cities[0][2]="São Paul";cities[0][3]="Salvador";cities[0][4]="Fortaleza";
        cities[1][0]="Ottawa";cities[1][1]="Toronto";cities[1][2]="Montreal";cities[1][3]="Calgary";cities[1][4]="Edmonton";
        cities[2][0]="Mexico City";cities[2][1]="Ecatepec";cities[2][2]="Puebla";cities[2][3]="Guadalajara";cities[2][4]="Ciudad Juárez";
        cities[3][0]="Buenos Aires";cities[3][1]="Córdoba";cities[3][2]="Rosario";cities[3][3]="Mendoza";cities[3][4]="La Plata";
        cities[4][0]="Lima";cities[4][1]="Arequipa";cities[4][2]="Trujillo";cities[4][3]="Chiclayo";cities[4][4]="Piura";
        cities[5][0]="Nassau";cities[5][1]="Freeport";cities[5][2]="West End";cities[5][3]="Coopers Town";cities[5][4]="Marsh Harbour";
        cities[6][0]="Bridgetown";cities[6][1]="Atlantic Shores";cities[6][2]="Bannatyne";cities[6][3]="Blue Waters";cities[6][4]="Callenders";
        //Africa
        cities[7][0]="Abuja";cities[7][1]="Lagos";cities[7][2]="Kano";cities[7][3]="Ibadan";cities[7][4]="Benin City";
        cities[8][0]="Cairo";cities[8][1]="Giza";cities[8][2]="Shubra el-Kheima";cities[8][3]="Port Said";cities[8][4]="Suez";
        cities[9][0]="Addis Ababa";cities[9][1]="Mekelle";cities[9][2]="Gondar";cities[9][3]="Adama";cities[9][4]="Hawassa";
        cities[10][0]="Dodoma";cities[10][1]="Dar es Salaam";cities[10][2]="Mwanza";cities[10][3]="Zanzibar City";cities[10][4]="Arusha";
        cities[11][0]="Kampala";cities[11][1]="Nansana";cities[11][2]="Kira";cities[11][3]="Ssabagabo";cities[11][4]="Mbarara";
        cities[12][0]="Rabat";cities[12][1]="Casablanca";cities[12][2]="Fez";cities[12][3]="Tangier";cities[12][4]="Marrakesh";
        cities[13][0]="Harare";cities[13][1]="Bulawayo";cities[13][2]="Chitungwiza";cities[13][3]="Mutare";cities[13][4]="Epworth";
        //Europe
        cities[14][0]="Paris";cities[14][1]="Marseille";cities[14][2]="Lyon";cities[14][3]="Toulouse";cities[14][4]="Nice";
        cities[15][0]="Rome";cities[15][1]="Milan";cities[15][2]="Naples";cities[15][3]="Turin";cities[15][4]="Palermo";
        cities[16][0]="Berlin";cities[16][1]="Hamburg";cities[16][2]="Munich";cities[16][3]="Cologne";cities[16][4]="Frankfurt am Main";
        cities[17][0]="Madrid";cities[17][1]="Barcelona";cities[17][2]="Valencia(–Sagunto)";cities[17][3]="Seville";cities[17][4]="Bilbao";
        cities[18][0]="London";cities[18][1]="Aberdeen";cities[18][2]="Armagh";cities[18][3]="Bangor";cities[18][4]="Bath";
        cities[19][0]="Moscow";cities[19][1]="Saint Petersburg";cities[19][2]="Novosibirsk";cities[19][3]="Yekaterinburg";cities[19][4]="Kazan";
        cities[20][0]="Athens";cities[20][1]="Thessaloniki";cities[20][2]="Patras";cities[20][3]="Piraeus";cities[20][4]="Larissa";
        //Asia
        cities[21][0]="Beijing";cities[21][1]="Hong Kong";cities[21][2]="Macau";cities[21][3]="Chongqing";cities[21][4]="Shanghai";
        cities[22][0]="Tokyo";cities[22][1]="Nagoya";cities[22][2]="Toyohashi";cities[22][3]="Okazaki";cities[22][4]="Ichinomiya";
        cities[23][0]="Bangkok";cities[23][1]="Nonthaburi";cities[23][2]="Pak Kret";cities[23][3]="Hat Yai";cities[23][4]="Chaophraya Surasak";
        cities[24][0]="Ankara";cities[24][1]="Istanbul";cities[24][2]="İzmir";cities[24][3]="Bursa";cities[24][4]="Adana";
        cities[25][0]="Kathmandu";cities[25][1]="Pokhara";cities[25][2]="Lalitpur";cities[25][3]="Bharatpur";cities[25][4]="Biratnagar";
        cities[26][0]="Colombo";cities[26][1]="Dehiwala Mount Lavinia";cities[26][2]="Moratuwa";cities[26][3]="Sri Jayawardenapura Kotte";cities[26][4]="Negombo";
        cities[27][0]="Tbilisi";cities[27][1]="Batumi";cities[27][2]="Kutaisi";cities[27][3]="Rustavi";cities[27][4]="Gori";
        cities[28][0]="";cities[28][1]="";cities[28][2]="";cities[28][3]="";cities[28][4]="";

        //Brazil
        facts[0][0]="3,015,268";facts[0][1]="5,802 km^2";
        facts[1][0]="6,718,903";facts[1][1]="1,183 km^2";
        facts[2][0]="12,252,023";facts[2][1]="1,522.99 km^2";
        facts[3][0]="2,872,347";facts[3][1]="km^2";
        facts[4][0]="2,669,342";facts[4][1]="km^2";
        //Canada
        facts[5][0]="934,243";facts[5][1]="2,790.30 km^2";
        facts[6][0]="2,731,571";facts[6][1]="630.20 km^2";
        facts[7][0]="1,704,694";facts[7][1]="431.50 km^2";
        facts[8][0]="1,239,220";facts[8][1]="825.56 km^2";
        facts[9][0]="932,546";facts[9][1]="767.85 km^2";
        //Mexico
        facts[10][0]="8,918,653";facts[10][1]="1,485  km^2";
        facts[11][0]="1,656,107";facts[11][1]="160.17 km^2";
        facts[12][0]="6,168,883";facts[12][1]="34,306 km^2";
        facts[13][0]="1,460,148 ";facts[13][1]="151 km^2";
        facts[14][0]="1,321,004";facts[14][1]="321.19 km^2";
        //Argentina
        facts[15][0]="15,594,428";facts[15][1]="203 km^2";
        facts[16][0]="3,308,876";facts[16][1]="165,321 km^2";
        facts[17][0]="1,700,000";facts[17][1]="178.69 km^2";
        facts[18][0]="115,021";facts[18][1]="54 km^2";
        facts[19][0]="765,378";facts[19][1]="203 km^2";
        //Peru
        facts[20][0]="8,838,102";facts[20][1]="2,672.3 km^2";
        facts[21][0]="1,008,290";facts[21][1]="69 km^2";
        facts[22][0]="919,899";facts[22][1]="1,100km^2";
        facts[23][0]="552,508";facts[23][1]="174.46 km^2";
        facts[24][0]="484,475";facts[24][1]="621.2 km^2";
        //Bahamas
        facts[25][0]="274,400";facts[25][1]="207 km^2";
        facts[26][0]="26,914";facts[26][1]="558 km^2";
        facts[27][0]="13,577";facts[27][1]="248 km^2";
        facts[28][0]="676";facts[28][1]=" 90 km^2";
        facts[29][0]="6,283";facts[29][1]="132 km^2";
        //Barbados
        facts[30][0]="11,000";facts[30][1]="40 km^2";
        facts[31][0]="6,875";facts[31][1]="68 km^2";
        facts[32][0]="10,973";facts[32][1]="100 km^2";
        facts[33][0]="8,546";facts[33][1]="56 km^2";
        facts[34][0]="32,438";facts[34][1]="43 km^2";
        //Negeria
        facts[35][0]="776,298";facts[35][1]="1,769 km^2";
        facts[36][0]="8,048,430";facts[36][1]="1,171.3 km^2";
        facts[37][0]="2,828,861";facts[37][1]="449 km^2";
        facts[38][0]="2,559,853";facts[38][1]="3,080 km^2";
        facts[39][0]="1,147,188";facts[39][1]="1,204 km^2";
        //Egypt
        facts[40][0]="19,500,000";facts[40][1]="214 km^2";
        facts[41][0]="4,779,000";facts[41][1]="570 km^2";
        facts[42][0]="1,025,569";facts[42][1]="320 km^2";
        facts[43][0]="500,000";facts[43][1]="263 km^2";
        facts[44][0]="744,189";facts[44][1]="475 km^2";
        //Ethiopia
        facts[45][0]="3,384,569";facts[45][1]="527 km^2";
        facts[46][0]="310,436";facts[46][1]="94 km^2";
        facts[47][0]="299,969";facts[47][1]="192.27 km^2";
        facts[48][0]="324,000";facts[48][1]="86 km^2";
        facts[49][0]="315,267";facts[49][1]="50 km^2";
        //Tanzania
        facts[50][0]="410,956";facts[50][1]="2,576 km^2";
        facts[51][0]="5,275,315";facts[51][1]="1,493 km^2";
        facts[52][0]="800,000";facts[52][1]="103 km^2";
        facts[53][0]="205,870";facts[53][1]="65 km^2";
        facts[54][0]="416,442";facts[54][1]="140 km^2";
        //Uganda
        facts[55][0]="1,650,600";facts[55][1]="189 km^2";
        facts[56][0]="365,124";facts[56][1]="459 km^2";
        facts[57][0]="317,157";facts[57][1]="98.83 km^2";
        facts[58][0]="284,067";facts[58][1]="531 km^2";
        facts[59][0]="195,013";facts[59][1]="213 km^2";
        //Morocco
        facts[60][0]="577,827";facts[60][1]="117 km^2";
        facts[61][0]="3,359,818";facts[61][1]="220 km^2";
        facts[62][0]="1,112,072";facts[62][1]="320 km^2";
        facts[63][0]="947,952";facts[63][1]="867 km^2";
        facts[64][0]="928,850";facts[64][1]="866 km^2";
        //Zimbabwe
        facts[65][0]="2,123,132";facts[65][1]="960.6 km^2";
        facts[66][0]="1,200,337";facts[66][1]="1,706.8 km^2";
        facts[67][0]="456,000";facts[67][1]="45 km^2";
        facts[68][0]="188,243";facts[68][1]="51 km^2";
        facts[69][0]="152,116";facts[69][1]="48 km^2";
        //France
        facts[70][0]="2,229,621";facts[70][1]="105.4 km^2";
        facts[71][0]="855,393";facts[71][1]="240.62 km^2";
        facts[72][0]="500,715";facts[72][1]="319 km^2";
        facts[73][0]="458,298";facts[73][1]="118.3 km^2";
        facts[74][0]="342,295";facts[74][1]="71.92 km^2";
        //Italy
        facts[75][0]="2,860,009";facts[75][1]="1,285 km^2";
        facts[76][0]="1,396,059";facts[76][1]="181.76 km^2";
        facts[77][0]="962,589";facts[77][1]="119.02 km^2";
        facts[78][0]="870,952";facts[78][1]="130.17 km^2";
        facts[79][0]="657,960";facts[79][1]="158.9 km^2";
        //Germany
        facts[80][0]="3,520,031";facts[80][1]="891.68 km^2";
        facts[81][0]="1,787,408";facts[81][1]="755.3  km^2";
        facts[82][0]="1,450,381";facts[82][1]="310.7 km^2";
        facts[83][0]="1,060,582";facts[83][1]="405.02 km^2";
        facts[84][0]="732,688";facts[84][1]="248.31 km^2";
        //Spain
        facts[85][0]="3,266,126";facts[85][1]="604.3 km^2";
        facts[86][0]="5,355,127";facts[86][1]="4,268 km^2";
        facts[87][0]="801,456";facts[87][1]="134.65 km^2";
        facts[88][0]="688,711";facts[88][1]="140 km^2";
        facts[89][0]="987,000";facts[89][1]="361.3 km^2";
        //United Kingdom
        facts[90][0]="8,982,000 ";facts[90][1]="1,579 km^2";
        facts[91][0]="196,670";facts[91][1]="185.7 km^2";
        facts[92][0]="14,777";facts[92][1]="10.3 km^2";
        facts[93][0]="16,358";facts[93][1]="28 km^2";
        facts[94][0]="15,384";facts[94][1]="64 km^2";
        //Russia
        facts[95][0]="12,480,481";facts[95][1]="2,511 km^2";
        facts[96][0]="5,398,064";facts[96][1]="1,439 km^2";
        facts[97][0]="1,625,631";facts[97][1]="502.7 km^2";
        facts[98][0]="1,493,749";facts[98][1]="495 km^2";
        facts[99][0]="1,257,391";facts[99][1]="425.3 km^2";
        //Greece
        facts[100][0]="664,046";facts[100][1]="38.964 km^2";
        facts[101][0]="315,196";facts[101][1]="19.307 km^2";
        facts[102][0]="167,446";facts[102][1]="334.9 km^2";
        facts[103][0]="163,688";facts[103][1]="50.417 km^2";
        facts[104][0]="144,651";facts[104][1]="335.98 km^2";
        //China
        facts[105][0]="21,542,000";facts[105][1]="16,410.5km^2";
        facts[106][0]="7,500,700";facts[106][1]="2,755 km^2";
        facts[107][0]="696,100";facts[107][1]="115.3 km^2";
        facts[108][0]="31,018,000";facts[108][1]="82,403 km^2";
        facts[109][0]="24,281,400";facts[109][1]="6,341 km^2";
        //Japan
        facts[110][0]="13,929,280";facts[110][1]="2,194.07 km^2";
        facts[111][0]="2,283,289";facts[111][1]="326.45 km^2";
        facts[112][0]="377,045";facts[112][1]="261.35 km^2";
        facts[113][0]="371,380";facts[113][1]="387.24 km^2";
        facts[114][0]="375,939";facts[114][1]="113.91 km^2";
        //Thailand
        facts[115][0]="5,666,264";facts[115][1]="1,568.74 km^2";
        facts[116][0]="254,375";facts[116][1]="38.90 km^2";
        facts[117][0]="190,272";facts[117][1]="36.04 km^2";
        facts[118][0]="156,802";facts[118][1]="21 km^2";
        facts[119][0]="143,024";facts[119][1]="276.98 km^2";
        //Turkey
        facts[120][0]="4,587,558";facts[120][1]="24,521 km^2";
        facts[121][0]="14,025,646";facts[121][1]="2,576.85 km^2";
        facts[122][0]="2,847,691";facts[122][1]="11,891 km^2";
        facts[123][0]="1,854,285";facts[123][1]="1,036 km^2";
        facts[124][0]="1,563,545";facts[124][1]="1,945 km^2";
        //Nepal
        facts[125][0]="985,453";facts[125][1]="49.45km^2";
        facts[126][0]="426,759";facts[126][1]="464.28 km^2";
        facts[127][0]="284,922";facts[127][1]="36.12 km^2";
        facts[128][0]="280,502";facts[128][1]="432.95 km^2";
        facts[129][0]="242,548";facts[129][1]="77 km^2";
        //Sri Lanka
        facts[130][0]="561,314";facts[130][1]="37 km^2";
        facts[131][0]="184,468";facts[131][1]="21 km^2";
        facts[132][0]="168,280";facts[132][1]="23 km^2";
        facts[133][0]="107,925";facts[133][1]="17 km^2";
        facts[134][0]="142,449";facts[134][1]="31 km^2";
        //Georgia
        facts[135][0]="1,184,282";facts[135][1]="504.2 km^2";
        facts[136][0]="204,156";facts[136][1]="200 km^2";
        facts[137][0]="147,635";facts[137][1]="67.7 km^2";
        facts[138][0]="125,103";facts[138][1]="60.6 km^2";
        facts[139][0]="48,143";facts[139][1]="16.85 km^2";
    }

    @Override
    public void onItemSelected(AdapterView<?> par, View view, int pos, long id) {
        switch (par.getId()){
            case R.id.land:
                opl=pos-1;
                choice(pos,opl);
            break;
            case R.id.country:
                opc=pos-1;
                if ((pos-1)<0) {
                    ArrayAdapter<String> ci= new ArrayAdapter<String>(this,R.layout.
                            support_simple_spinner_dropdown_item,cities[28]);
                    city.setAdapter(ci);
                }
                else {
                    ArrayAdapter<String> ci = new ArrayAdapter<String>(this, R.layout.
                            support_simple_spinner_dropdown_item, cities[opl*7+(pos-1)]);
                    city.setAdapter(ci);
                }
            break;
        }
    }

    private void choice(int pos,int op) {
        switch (pos-1){
            case 0:ArrayAdapter<String> c=new ArrayAdapter<String>(this,R.layout.
                    support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.America));
                country.setAdapter(c);break;
            case 1:c=new ArrayAdapter<String>(this,R.layout.
                    support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.Africa));
                country.setAdapter(c);break;
            case 2:c=new ArrayAdapter<String>(this,R.layout.
                    support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.Europe));
                country.setAdapter(c);break;
            case 3:c=new ArrayAdapter<String>(this,R.layout.
                    support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.Asia));
                country.setAdapter(c);break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        pop.setText("Population="+facts[opl*35+opc*5+pos][0]);
        area.setText("Area="+facts[opl*35+opc*5+pos][1]);
    }
//7*(pos+5)
}