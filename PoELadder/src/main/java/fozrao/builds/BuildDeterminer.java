package fozrao.builds;

import static fozrao.constants.KeystonePassives.ACROBATICS_DISPLAY;
import static fozrao.constants.KeystonePassives.ACROBATICS_ID;
import static fozrao.constants.KeystonePassives.ANCESTRAL_BOND_DISPLAY;
import static fozrao.constants.KeystonePassives.ANCESTRAL_BOND_ID;
import static fozrao.constants.KeystonePassives.ARROW_DANCING_DISPLAY;
import static fozrao.constants.KeystonePassives.ARROW_DANCING_ID;
import static fozrao.constants.KeystonePassives.AVATAR_OF_FIRE_DISPLAY;
import static fozrao.constants.KeystonePassives.AVATAR_OF_FIRE_ID;
import static fozrao.constants.KeystonePassives.BLOOD_MAGIC_DISPLAY;
import static fozrao.constants.KeystonePassives.BLOOD_MAGIC_ID;
import static fozrao.constants.KeystonePassives.CHAOS_INCOULATION_DISPLAY;
import static fozrao.constants.KeystonePassives.CHAOS_INCOULATION_ID;
import static fozrao.constants.KeystonePassives.CONDUIT_DISPLAY;
import static fozrao.constants.KeystonePassives.CONDUIT_ID;
import static fozrao.constants.KeystonePassives.ELDRITCH_BATTERY_DISPLAY;
import static fozrao.constants.KeystonePassives.ELDRITCH_BATTERY_ID;
import static fozrao.constants.KeystonePassives.ELEMENTAL_EQUILIBRIUM_DISPLAY;
import static fozrao.constants.KeystonePassives.ELEMENTAL_EQUILIBRIUM_ID;
import static fozrao.constants.KeystonePassives.ELEMENTAL_OVERLOAD_DISPLAY;
import static fozrao.constants.KeystonePassives.ELEMENTAL_OVERLOAD_ID;
import static fozrao.constants.KeystonePassives.GHOST_REAVER_DISPLAY;
import static fozrao.constants.KeystonePassives.GHOST_REAVER_ID;
import static fozrao.constants.KeystonePassives.IRON_GRIP_DISPLAY;
import static fozrao.constants.KeystonePassives.IRON_GRIP_ID;
import static fozrao.constants.KeystonePassives.IRON_REFLEXES_DISPLAY;
import static fozrao.constants.KeystonePassives.IRON_REFLEXES_ID;
import static fozrao.constants.KeystonePassives.MIND_OVER_MATTER_DISPLAY;
import static fozrao.constants.KeystonePassives.MIND_OVER_MATTER_ID;
import static fozrao.constants.KeystonePassives.MINION_INSTABILITY_DISPLAY;
import static fozrao.constants.KeystonePassives.MINION_INSTABILITY_ID;
import static fozrao.constants.KeystonePassives.NECROMANTIC_AEGIS_DISPLAY;
import static fozrao.constants.KeystonePassives.NECROMANTIC_AEGIS_ID;
import static fozrao.constants.KeystonePassives.PAIN_ATTUNEMENT_DISPLAY;
import static fozrao.constants.KeystonePassives.PAIN_ATTUNEMENT_ID;
import static fozrao.constants.KeystonePassives.PHASE_ACROBATICS_DISPLAY;
import static fozrao.constants.KeystonePassives.PHASE_ACROBATICS_ID;
import static fozrao.constants.KeystonePassives.POINT_BLANK_DISPLAY;
import static fozrao.constants.KeystonePassives.POINT_BLANK_ID;
import static fozrao.constants.KeystonePassives.RESOLUTE_TECHNIQUE_DISPLAY;
import static fozrao.constants.KeystonePassives.RESOLUTE_TECHNIQUE_ID;
import static fozrao.constants.KeystonePassives.UNWAVERING_STANCE_DISPLAY;
import static fozrao.constants.KeystonePassives.UNWAVERING_STANCE_ID;
import static fozrao.constants.KeystonePassives.VAAL_PACT_DISPLAY;
import static fozrao.constants.KeystonePassives.VAAL_PACT_ID;
import static fozrao.constants.KeystonePassives.ZEALOTS_OATH_DISPLAY;
import static fozrao.constants.KeystonePassives.ZEALOTS_OATH_ID;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fozrao.constants.KeystonePassives;
import fozrao.entities.profile.CharacterProfile;

public class BuildDeterminer {
	
	private static Map<Integer, String> keystones = new HashMap<Integer, String>();
	
	static {
		keystones.put(ACROBATICS_ID, ACROBATICS_DISPLAY);
		keystones.put(ANCESTRAL_BOND_ID, ANCESTRAL_BOND_DISPLAY);
		keystones.put(ARROW_DANCING_ID, ARROW_DANCING_DISPLAY);
		keystones.put(AVATAR_OF_FIRE_ID, AVATAR_OF_FIRE_DISPLAY);
		keystones.put(BLOOD_MAGIC_ID, BLOOD_MAGIC_DISPLAY);
		keystones.put(CHAOS_INCOULATION_ID, CHAOS_INCOULATION_DISPLAY);
		keystones.put(CONDUIT_ID, CONDUIT_DISPLAY);
		keystones.put(ELDRITCH_BATTERY_ID, ELDRITCH_BATTERY_DISPLAY);
		keystones.put(ELEMENTAL_EQUILIBRIUM_ID, ELEMENTAL_EQUILIBRIUM_DISPLAY);
		keystones.put(ELEMENTAL_OVERLOAD_ID, ELEMENTAL_OVERLOAD_DISPLAY);
		keystones.put(GHOST_REAVER_ID, GHOST_REAVER_DISPLAY);
		keystones.put(IRON_GRIP_ID, IRON_GRIP_DISPLAY);
		keystones.put(IRON_REFLEXES_ID, IRON_REFLEXES_DISPLAY);
		keystones.put(MIND_OVER_MATTER_ID, MIND_OVER_MATTER_DISPLAY);
		keystones.put(MINION_INSTABILITY_ID, MINION_INSTABILITY_DISPLAY);
		keystones.put(NECROMANTIC_AEGIS_ID, NECROMANTIC_AEGIS_DISPLAY);
		keystones.put(PAIN_ATTUNEMENT_ID, PAIN_ATTUNEMENT_DISPLAY);
		keystones.put(PHASE_ACROBATICS_ID, PHASE_ACROBATICS_DISPLAY);
		keystones.put(POINT_BLANK_ID, POINT_BLANK_DISPLAY);
		keystones.put(RESOLUTE_TECHNIQUE_ID, RESOLUTE_TECHNIQUE_DISPLAY);
		keystones.put(UNWAVERING_STANCE_ID, UNWAVERING_STANCE_DISPLAY);
		keystones.put(VAAL_PACT_ID, VAAL_PACT_DISPLAY);
		keystones.put(ZEALOTS_OATH_ID, ZEALOTS_OATH_DISPLAY);
	}
	
	public String getBuild(CharacterProfile profile)
	{
		Set<Integer> passives = IntStream.of(profile.hashes).boxed().collect(Collectors.toSet());
		
		passives.retainAll(keystones.keySet());
		
		String build = passives.stream()
				.map(p -> getKeystoneDisplay(p))
				.collect(Collectors.joining(","));
		
		return build;
	}
	
	private String getKeystoneDisplay(int keystoneId)
	{
		return keystones.get(keystoneId);
	}
}
