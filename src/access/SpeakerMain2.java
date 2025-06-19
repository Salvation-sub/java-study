package access;

public class SpeakerMain2 {
    public static void main(String[] args) {
        PrivateSpeaker speaker = new PrivateSpeaker(90);
        speaker.showVolume();
        speaker.volumeUp();
        speaker.showVolume();
        speaker.volumeUp();
        speaker.showVolume();

        //필드에 직접 접근해서 설정해둔 최대 volume을 수정 불가능
        System.out.println("volume 필드 직접 접근 수정");
//        speaker.volume = 200;
        speaker.showVolume();
    }

}
