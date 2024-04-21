package com.example.agrodoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList<DataModel> list;

    public Adapter(Context context, ArrayList<DataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel data = list.get(position);
        String firstChar = data.cropName.substring(0, 1).toUpperCase();
        String restOfString = data.cropName.substring(1);
        holder.text.setText("Crop Name :- "+firstChar + restOfString);

        if (data.cropName.equalsIgnoreCase("cotton")){
            holder.ct.setText("March to May");
            holder.img.setImageResource(R.drawable.cotton);
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-150 P-60 K-60 ");
            holder.desc.setText("Cotton is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family Malvaceae. The fiber is almost pure cellulose, and can contain minor percentages of waxes, fats, pectins, and water.");

        } else if (data.cropName.equalsIgnoreCase("rice(r)")) {
            holder.img.setImageResource(R.drawable.ricer);
            holder.ct.setText("November to February");
            holder.desc.setText("Red rice is a variety of rice that is colored red by its anthocyanin content. It is usually eaten unpolished or partially polished, and has a red bran layer, rather than the more common pale brown");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-120 P-30 K-30 ");
        }
        else if (data.cropName.equalsIgnoreCase("wheat")) {
            holder.img.setImageResource(R.drawable.wheat);
            holder.ct.setText("October");
            holder.desc.setText("n India, it is grown mostly in the plains, where as in the hills it is cultivated in mountainous regions of north India and Nilgiri and Palani hills in south India. It is grown under a wide range of climatic conditions from Kashmir and other mountainous regions to semiarid regions with mild to severe winter.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-120 P-60 K-30 ");
        }
        else if (data.cropName.equalsIgnoreCase("rice(k)")) {
            holder.img.setImageResource(R.drawable.krice);
            holder.ct.setText("November to February");
            holder.desc.setText("Oryza sativa, also known as rice (k), is the plant species most commonly referred to in English as rice. It is the type of farmed rice whose cultivars are most common globally, and was first domesticated in the Yangtze River basin in China 13,500 to 8,200 years ago");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-120 P-30 K-30 ");
        }
        else if (data.cropName.equalsIgnoreCase("sorghum")) {
            holder.img.setImageResource(R.drawable.sorghum);
            holder.ct.setText("May");
            holder.desc.setText("Sorghum is a strong grass and usually grows to a height of 0.6 to 2.4 metres (2 to 8 feet), sometimes reaching as high as 4.6 metres (15 feet). Stalks and leaves are coated with a white wax, and the pith, or central portion, of the stalks of certain varieties is juicy and sweet");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-80 P-40 K-40 ");
        }
        else if (data.cropName.equalsIgnoreCase("maize")) {
            holder.img.setImageResource(R.drawable.maize);
            holder.ct.setText("April and May");
            holder.desc.setText("Maize or Indian corn is a stout annual plant cultiDvated for the grains during the rainy season. It forms a staple food in some parts of India. Roots are of fibrous adventitious type. Primary root aborts after germination, and is replaced by fibrous adventitious ones from the base of stem.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-80 P-40 K-20 ");
        }
        else if (data.cropName.equalsIgnoreCase("pulses")) {
            holder.img.setImageResource(R.drawable.pulses);
            holder.ct.setText("Kharif Rabi and Zaid season");
            holder.desc.setText("Pulses are annual crops that yield between one and 12 grains or seeds. The term “pulses” is limited to crops harvested solely as dry grains, which differentiates them from other vegetable crops that are harvested while still green.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-20 P-60 K-20 ");
        }
        else if (data.cropName.equalsIgnoreCase("p.millet")) {
            holder.img.setImageResource(R.drawable.millet);
            holder.ct.setText("June");
            holder.desc.setText("The most extensively cultivated millet is pearl millet (Pennisetum glaucum, P. typhoides, Pryhpideum, and P. americanum). Large stems, leaves, and heads characterise this summer cereal grass. In terms of farmed land and contributions to food security in parts of Africa and Asia that can only produce limited amounts of other crops, pearl millet is the most significant species of millet");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-120 P-60 K-0 ");
        }
        else if (data.cropName.equalsIgnoreCase("potato")) {
            holder.img.setImageResource(R.drawable.potato);
            holder.ct.setText("October - December");
            holder.desc.setText("Potato, (Solanum tuberosum), annual plant in the nightshade family (Solanaceae), grown for its starchy edible tubers. The potato is native to the Peruvian-Bolivian Andes and is one of the world’s main food crops. Potatoes are frequently served whole or mashed as a cooked vegetable and are also ground into potato flour, used in baking and as a thickener for sauces. The tubers are highly digestible and supply vitamin C, protein, thiamin, and niacin.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-180 P-60 K-90 ");
        }
        else if (data.cropName.equalsIgnoreCase("rice")) {
            holder.img.setImageResource(R.drawable.rice);
            holder.ct.setText("November to February");
            holder.desc.setText("Rice (Oryza sativa L.) is a plant belonging to the family of grasses, Gramineae (Poaceae). It is one of the three major food crops of the world and forms the staple diet of about half of the world's population.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-120 P-60 K-40 ");
        }
        else if (data.cropName.equalsIgnoreCase("soybean")) {
            holder.img.setImageResource(R.drawable.soybean);
            holder.ct.setText("Mid June to Mid July");
            holder.desc.setText("Soybean, (Glycine max), annual legume of the pea family (Fabaceae) and its edible seed. The soybean is economically the most important bean in the world, providing vegetable protein for millions of people and ingredients for hundreds of chemical products.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-60 P-60 K-20 ");
        }
        else if (data.cropName.equalsIgnoreCase("groundnut")) {
            holder.img.setImageResource(R.drawable.groundnut);
            holder.ct.setText("May June");
            holder.desc.setText("The groundnut is a low growing annual plant. The groundnut plant has prostrated to upright stems that sometimes reach a height of 46 cm. The plant usually grows slowly until about 40 days after planting. Plants start flowering about 25-40 days after planting. Growth is more rapid between 40-100 days.");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-15 P-25 K-0 ");
        }
        else if (data.cropName.equalsIgnoreCase("sugarcane")) {
            holder.ct.setText("December and January");
            holder.desc.setText("Sugarcane, (Saccharum officinarum), perennial grass of the family Poaceae, primarily cultivated for its juice from which sugar is processed. Most of the world’s sugarcane is grown in subtropical and tropical areas");
            holder.img.setImageResource(R.drawable.sugarcane);
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-250 P-115 K-115 ");
        }
        else if (data.cropName.equalsIgnoreCase("mustard")) {
            holder.ct.setText("September -October");
            holder.desc.setText("Mustard, condiment made from the pungent seeds of either of two main herbs belonging to the family Brassicaceae. Both white, or yellow, mustard and brown mustard are widely used as a condiment with various foods, particularly cold meats, sausages, and salad dressings.");
            holder.img.setImageResource(R.drawable.mustard);
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-100 P-30 K-15 ");
        }
        else {
            holder.ct.setText("March to May");
            holder.desc.setText("Sunflower, Helianthus annuus, is an herbaceous annual plant in the family Asteraceae, grown for its seeds. The plant has a thick, hairy, erect stem which gives rise to a large flower head. The plant has large, broad lower leaves which are oval and arranged alternately on the stem and smaller, narrower upper leaves which are attached individually to the stem. The flower head is a large disc reaching 10–30 cm (4–12 in) in diameter which is made up of 16–30 individual florets which are yellow-gold in color");
            holder.fertilizer.setText("Fertilizer Requirement (kg/ha):-\n N-60 P-60 K-30 ");
            holder.img.setImageResource(R.drawable.sunflower);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView text,desc,fertilizer,ct;
    ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text=itemView.findViewById(R.id.text);
            ct=itemView.findViewById(R.id.ct);
            img=itemView.findViewById(R.id.img);
            desc=itemView.findViewById(R.id.desc);
            fertilizer=itemView.findViewById(R.id.fertilizer);
            // Initialize your view elements here
            // Example:
            // titleTextView = itemView.findViewById(R.id.titleTextView);
            // imageView = itemView.findViewById(R.id.imageView);
        }


    }
}
